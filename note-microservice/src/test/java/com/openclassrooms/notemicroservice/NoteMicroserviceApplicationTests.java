package com.openclassrooms.notemicroservice;

import com.openclassrooms.notemicroservice.model.Note;
import com.openclassrooms.notemicroservice.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoteMicroserviceApplicationTests {

    @Autowired
    NoteRepository repository;

    @Test
    void testCrudNote() {

        Note note = new Note("Tests de laboratoire indiquant une microalbumine élevée", 3L);

        // Save
        note = repository.save(note);
        assertNotNull(note.getId());

        // Update
        note.setContent("x");
        note = repository.save(note);
        assertEquals("x", note.getContent());

        // Find
        List<Note> noteList = repository.findAll();
        assertTrue(noteList.size() > 0);

        // Find by id
        Optional<Note> noteId = repository.findById(note.getId());
        assertEquals(noteId.get().getId(), note.getId());

        // Delete
        String id = note.getId();
        repository.delete(note);
        Optional<Note> optionalNote = repository.findById(id);
        assertFalse(optionalNote.isPresent());
    }
}

