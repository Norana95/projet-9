package com.frontend.frontendMicroservice.controller;

import com.frontend.frontendMicroservice.beans.AssessBean;
import com.frontend.frontendMicroservice.beans.PatientBean;
import com.frontend.frontendMicroservice.proxies.AssessMicroserviceProxy;
import com.frontend.frontendMicroservice.proxies.PatientMicroserviceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class assessController {

    private final PatientMicroserviceProxy patientProxy;

    private final AssessMicroserviceProxy assessProxy;

    public assessController(PatientMicroserviceProxy patientProxy, AssessMicroserviceProxy assessProxy) {
        this.patientProxy = patientProxy;
        this.assessProxy = assessProxy;
    }

    @GetMapping("/patient/DiabetesReport/{id}")
    public String addAndGetAssessByPatId(@PathVariable("id") Long patId, Model model) {
        PatientBean patient = patientProxy.getPatientbyId(patId);
        String s = assessProxy.addAndGetAssessByPatId(patId);
        model.addAttribute("risk", s);
        return "assess/getAssess";
    }


}
