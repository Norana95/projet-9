package com.projet9.assess.service;

import com.projet9.assess.beans.NoteBean;
import com.projet9.assess.beans.PatientBean;
import com.projet9.assess.model.RiskLevels;
import com.projet9.assess.proxies.NoteMicroserviceProxy;
import com.projet9.assess.proxies.PatientMicroserviceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssessService {

    public final NoteMicroserviceProxy noteProxy;
    public final PatientMicroserviceProxy patientProxy;

    public AssessService(NoteMicroserviceProxy noteProxy, PatientMicroserviceProxy patientProxy) {
        this.noteProxy = noteProxy;
        this.patientProxy = patientProxy;
    }


    public int calculAge(Date d) {
        Calendar curr = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(d);
        int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        curr.add(Calendar.YEAR, -yeardiff);
        if (birth.after(curr)) {
            yeardiff = yeardiff - 1;
        }
        return yeardiff;
    }

    public RiskLevels getRiskLevels(Long patId) {
        List<NoteBean> notesPatient = noteProxy.getNotesByPatId(patId);
        int terminologieNumber = 1;
        //get number of terminologie contains in note
        for (NoteBean note : notesPatient) {
            List<String> terminologieList = Arrays.asList("Hémoglobine A1C", "Microalbumine", "Taille", "Poids", "Fumeur", "Anormal", "Cholestérol", "Vertige", "Rechute", "Réaction", "Anticorps");
            for (String s : terminologieList) {
                if (note.getContent().contains(s)) {
                    ++terminologieNumber;
                    break;
                }
            }
        }
        if (terminologieNumber == 0) {
            return RiskLevels.none;
        }
        PatientBean patientBean = patientProxy.getPatientbyId(patId);
        int age = calculAge(patientBean.dob);
        if (age >= 30) {
            if (terminologieNumber == 2) {
                return RiskLevels.borderline;
            }
            if (terminologieNumber == 6) {
                return RiskLevels.InDanger;
            }
            if (terminologieNumber >= 8) {
                return RiskLevels.earlyOnset;
            }
        }
        if (age <= 30) {
            if (patientBean.sex.equalsIgnoreCase("h")) {
                if (terminologieNumber == 3) {
                    return RiskLevels.InDanger;
                }
                if (terminologieNumber == 5) {
                    return RiskLevels.earlyOnset;
                }
            }
            if (patientBean.sex.equalsIgnoreCase("f")) {
                if (terminologieNumber == 4) {
                    return RiskLevels.InDanger;
                }
                if (terminologieNumber == 7) {
                    return RiskLevels.earlyOnset;
                }
            }
        }
        return RiskLevels.none;
    }
}
