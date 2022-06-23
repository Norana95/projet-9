package com.projet9.assess.proxies;

import com.projet9.assess.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-note", url = "http://localhost:8083")
public interface NoteMicroserviceProxy {

    @GetMapping("/patient/historique/{id}")
    List<NoteBean> getNotesByPatId(@PathVariable("id") Long patId);

}
