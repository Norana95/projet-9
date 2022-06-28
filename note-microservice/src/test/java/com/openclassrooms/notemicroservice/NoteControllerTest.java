package com.openclassrooms.notemicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.notemicroservice.controller.NoteController;
import com.openclassrooms.notemicroservice.model.Note;
import com.openclassrooms.notemicroservice.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoteController.class)
public class NoteControllerTest {

    @MockBean
    NoteRepository noteRepository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    Note note = new Note( "test", 1L);


    @Test
    //@PostMapping("/note/validate")
    public void addNoteTest() throws Exception {
      mockMvc.perform(post("/note/validate").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(note))).andExpect(status().isOk());
    }

    @Test
    //@GetMapping("note/update/{id}")
    public void getNoteByIdTest() throws Exception {
        mockMvc.perform(get("/note/update/{id}", "62baea258df9d87c5f1fb10f")).andExpect(status().isOk());
    }

    @Test
    //@PostMapping("/note/update/{id}")
    public void noteUpdateTest() throws Exception {
        Note note = new Note("TestUpdateNote",4L);
        mockMvc.perform(post("/note/update/{id}",note.getId()).content(objectMapper.writeValueAsString(note)).contentType(MediaType.APPLICATION_JSON)).andReturn();
    }

    @Test
    //@GetMapping("/patient/historique/{patId}")
    public void getNotesByPatIdTest() throws Exception {
     mockMvc.perform(get("/patient/historique/{patId}", note.getPatId())).andExpect(status().isOk());
    }

    @Test
    //@GetMapping("/notes")
    public void getNotesListTest() throws Exception {
     mockMvc.perform(get("/notes")).andExpect(status().isOk());
    }


}
