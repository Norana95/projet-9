package com.frontend.frontendMicroservice.controller;

import com.frontend.frontendMicroservice.beans.NoteBean;
import com.frontend.frontendMicroservice.beans.PatientBean;
import com.frontend.frontendMicroservice.proxies.NoteMicroserviceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class NoteController {

    private final NoteMicroserviceProxy noteProxy;


    public NoteController(NoteMicroserviceProxy noteProxy) {
        this.noteProxy = noteProxy;
    }

    @GetMapping("/patient/historique/{patId}")
    public String getNotesByPatId(@PathVariable("patId") Long id, Model model) {
        List<NoteBean> notes = noteProxy.getNotesByPatId(id);
        model.addAttribute("notes", notes);
        return "note/listNote";
    }

    @GetMapping("/note/add/{patId}")
    public String getPageAddNote(NoteBean note, @PathVariable("patId") Long patId, Model model) {
        model.addAttribute("patId", patId);
        return "note/addNote";
    }

    @PostMapping("/note/validate")
    public String addNote(NoteBean note) {
        noteProxy.addNote(note);
        return "redirect:/patients";
    }

    @GetMapping("note/update/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model){
        NoteBean noteBean = noteProxy.getNoteById(id);
        model.addAttribute("noteBean", noteBean);
        return "note/updateNote";
    }

    @PostMapping("/note/update/{id}")
    public String noteUpdate(NoteBean noteBean, @PathVariable("id") String id) {
        noteProxy.noteUpdate(noteBean, id);
        return "redirect:/patients";
    }
}
