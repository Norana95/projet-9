package com.projet9.assess.controller;

import com.projet9.assess.beans.PatientBean;
import com.projet9.assess.model.Assess;
import com.projet9.assess.model.RiskLevels;
import com.projet9.assess.proxies.NoteMicroserviceProxy;
import com.projet9.assess.proxies.PatientMicroserviceProxy;
import com.projet9.assess.repository.AssessRepository;
import com.projet9.assess.service.AssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class AssessController {

    @Autowired
    AssessRepository assessRepository;

    private final NoteMicroserviceProxy noteProxy;

    private final PatientMicroserviceProxy patientProxy;

    @Autowired
    AssessService assessService;

    public AssessController(NoteMicroserviceProxy noteProxy, PatientMicroserviceProxy patientProxy) {
        this.noteProxy = noteProxy;
        this.patientProxy = patientProxy;
    }

    /* @PostMapping("/assess/id")
     public ResponseEntity<> postAssessId(@RequestBody Assess assess){

     }

     @PostMapping("/assess/familyName")
     public ResponseEntity<> postAssessFamilyName(@RequestBody Assess assess){

     }*/

    @GetMapping("/patient/DiabetesReport/{id}")
    public String addAndGetAssessByPatId(@PathVariable("id") Long patId){
        PatientBean patient = patientProxy.getPatientbyId(patId);
        RiskLevels riskLevel = assessService.getRiskLevels(patId);
        int age = assessService.calculAge(patient.dob);
        Optional<Assess> assess = assessRepository.findById(patId);
        if(assess.isPresent()){
            Assess AssessPresent = assess.get();
            AssessPresent.setRiskLevel(riskLevel);
            assessRepository.save(AssessPresent);
        }
        else{
            Assess newAssess = new Assess(patId,riskLevel);
            assessRepository.save(newAssess);
        }
        return "Patient : " + patient.family + " age(" + age +")" + " diabetes assessment is : " + riskLevel;
    }

}
