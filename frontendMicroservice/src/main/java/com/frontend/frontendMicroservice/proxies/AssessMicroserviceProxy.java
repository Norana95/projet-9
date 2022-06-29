package com.frontend.frontendMicroservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "microservice-assess", url = "http://localhost:8080")
public interface AssessMicroserviceProxy {

    @PostMapping("/patient/DiabetesReport/{id}")
    String addAndGetAssessByPatId(@PathVariable("id") Long patId);

}
