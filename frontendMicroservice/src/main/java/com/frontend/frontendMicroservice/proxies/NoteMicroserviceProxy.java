package com.frontend.frontendMicroservice.proxies;

import com.frontend.frontendMicroservice.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "microservice-note", url = "http://localhost:8083")
public interface NoteMicroserviceProxy {
    @PostMapping("/note/validate")
    void addNote(NoteBean note);
    @GetMapping("/patient/historique/{id}")
    List<NoteBean> getNotesByPatId(@PathVariable("id") Long patId);

    @GetMapping("note/update/{id}")
    NoteBean getNoteById(@PathVariable("id") String id);

    @PostMapping("/note/update/{id}")
    NoteBean noteUpdate(@RequestBody NoteBean note, @PathVariable("id") String id);
}
