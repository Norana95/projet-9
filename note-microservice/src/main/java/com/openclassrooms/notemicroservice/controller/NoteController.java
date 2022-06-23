package com.openclassrooms.notemicroservice.controller;

import com.openclassrooms.notemicroservice.model.Note;
import com.openclassrooms.notemicroservice.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @PostMapping("/note/validate")
    public void addNote(@RequestBody Note note) {
        noteRepository.save(note);
    }

    @GetMapping("note/update/{id}")
    public Optional<Note> getNoteById(@PathVariable("id") String id) {
        return noteRepository.findById(id);
    }

    @PostMapping("/note/update/{id}")
    public Note noteUpdate(@RequestBody Note note, @PathVariable("id") String id) {
        return noteRepository.findById(id)
                .map(oldNote -> {
                    oldNote.setContent(note.getContent());
                    oldNote.setDate(note.getDate());
                    oldNote.setName(note.getName());
                    return noteRepository.save(oldNote);
                })
                .orElseGet(() -> {
                    note.setId(id);
                    return noteRepository.save(note);
                });
    }

    @GetMapping("/patient/historique/{id}")
    public List<Note> getNotesByPatId(@PathVariable("id") Long patId){
      return noteRepository.findByPatId(patId);
    }
}
