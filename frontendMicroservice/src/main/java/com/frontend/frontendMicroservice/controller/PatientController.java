package com.frontend.frontendMicroservice.controller;

import com.frontend.frontendMicroservice.beans.NoteBean;
import com.frontend.frontendMicroservice.beans.PatientBean;
import com.frontend.frontendMicroservice.proxies.NoteMicroserviceProxy;
import com.frontend.frontendMicroservice.proxies.PatientMicroserviceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PatientController {

    private final PatientMicroserviceProxy patientProxy;

    public PatientController(PatientMicroserviceProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    @GetMapping("/")
    public String accueil() {
        return "index";
    }

    @GetMapping("/patient/add")
    public String getAddPatiendPage(PatientBean patientBean) {
        return "patient/addPatient";
    }

    @PostMapping("/patient/validate")
    public String createPatient(PatientBean patientBean) {
        patientProxy.createPatient(patientBean);
        return "redirect:/patients";
    }

    @GetMapping("/patients")
    public String allPatients(Model model) {
        model.addAttribute("allPatient", patientProxy.allPatients());
        return "patient/list";
    }

    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        PatientBean patientBean = patientProxy.getPatientbyId(id);
        model.addAttribute("patientBean", patientBean);
        return "patient/updatePatient";
    }

    @PostMapping("/patient/update/{id}")
    public String replacePatient(PatientBean newPatient, @PathVariable("id") Long id) {
        patientProxy.replacePatient(newPatient, id);
        return "redirect:/patients";
    }
}
