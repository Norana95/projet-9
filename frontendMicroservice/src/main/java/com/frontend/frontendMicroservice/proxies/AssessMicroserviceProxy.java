package com.frontend.frontendMicroservice.proxies;

import com.frontend.frontendMicroservice.beans.AssessBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.Optional;

@FeignClient(name = "microservice-assess", url = "http://localhost:8080")
public interface AssessMicroserviceProxy {

    @PostMapping("/patient/DiabetesReport/{id}")
    String addAndGetAssessByPatId(@PathVariable("id") Long patId);

}
