package com.projet9.patientmicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet9.patientmicroservice.model.Patient;
import com.projet9.patientmicroservice.repository.PatientRepository;
import com.projet9.patientmicroservice.web.controller.PatientController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @MockBean
    PatientRepository patientRepository;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createPatientTest() throws Exception {
        Patient patient = new Patient("testController", "testController");
        mockMvc.perform(post("/patient/add").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void allPatientsTest() throws Exception {
        mockMvc.perform(get("/patients"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getPatientbyIdTest() throws Exception {
        mockMvc.perform(get("/patients/{id}", "2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
