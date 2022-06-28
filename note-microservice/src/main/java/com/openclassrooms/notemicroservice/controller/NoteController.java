package com.openclassrooms.notemicroservice.controller;

import com.openclassrooms.notemicroservice.model.Note;
import com.openclassrooms.notemicroservice.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> noteUpdate(@RequestBody Note note, @PathVariable("id") String id) {
        return noteRepository.findById(id)
                .map(oldNote -> {
                    oldNote.setContent(note.getContent());
                    noteRepository.save(oldNote);
                    return ResponseEntity.ok("la note a été modifié");
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("cette note n'existe pas"));
    }

    @GetMapping("/patient/historique/{patId}")
    public List<Note> getNotesByPatId(@PathVariable("patId") Long patId) {
        return noteRepository.findByPatId(patId);
    }

    @GetMapping("/notes")
    public List<Note> getNotesList() {
        return noteRepository.findAll();
    }
}
