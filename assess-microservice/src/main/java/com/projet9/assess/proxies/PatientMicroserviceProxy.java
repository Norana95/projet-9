package com.projet9.assess.proxies;

import com.projet9.assess.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-patient", url = "http://localhost:8082")
public interface PatientMicroserviceProxy {

    @GetMapping("/patients/{id}")
    PatientBean getPatientbyId(@PathVariable("id") Long id);
}
