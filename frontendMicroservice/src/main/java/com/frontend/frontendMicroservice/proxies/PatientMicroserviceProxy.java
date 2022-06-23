package com.frontend.frontendMicroservice.proxies;

import com.frontend.frontendMicroservice.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-patient", url = "http://localhost:8082")
public interface PatientMicroserviceProxy {

    @PostMapping("/patient/add")
    PatientBean createPatient(PatientBean newPatient);

    @GetMapping("/patients")
    List<PatientBean> allPatients();

    @GetMapping("/patients/{id}")
    PatientBean getPatientbyId(@PathVariable("id") Long id);

    @PostMapping("/patient/update/{id}")
    PatientBean replacePatient(PatientBean newPatient, @PathVariable("id") Long id);
}
