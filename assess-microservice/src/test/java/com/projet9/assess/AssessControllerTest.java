package com.projet9.assess;

import com.projet9.assess.beans.PatientBean;
import com.projet9.assess.controller.AssessController;
import com.projet9.assess.model.Assess;
import com.projet9.assess.model.RiskLevels;
import com.projet9.assess.service.AssessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@WebMvcTest(controllers = AssessController.class)
public class AssessControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssessService assessService;

   /* @GetMapping("/patient/DiabetesReport/{id}")
    public String addAndGetAssessByPatId(@PathVariable("id") Long patId){
        PatientBean patient = patientProxy.getPatientbyId(patId);
        RiskLevels riskLevel = assessService.getRiskLevels(patId);
        int age = assessService.calculAge(patient.dob);
        Optional<Assess> assess = assessRepository.findById(patId);
        if(assess.isPresent()){
            Assess AssessPresent = assess.get();
            AssessPresent.setRiskLevel(riskLevel);
            assessRepository.save(AssessPresent);
        }
        else{
            Assess newAssess = new Assess(patId,riskLevel);
            assessRepository.save(newAssess);
        }
        return "Patient : " + patient.family + " age(" + age +")" + " diabetes assessment is : " + riskLevel;
    }*/



    @Test
    public void addAndGetAssessByPatId(){

    }


}
