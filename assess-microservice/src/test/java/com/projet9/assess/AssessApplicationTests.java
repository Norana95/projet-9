package com.projet9.assess;

import com.projet9.assess.model.Assess;
import com.projet9.assess.model.RiskLevels;
import com.projet9.assess.repository.AssessRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class AssessApplicationTests {

    @Autowired
    AssessRepository assessRepository;

    @Test
    void CrudAssessTest() {
        Assess assess = new Assess(5L,RiskLevels.borderline);
        assessRepository.save(assess);
        Assertions.assertNotNull(assessRepository.findById(5L));

        Optional<Assess> assess1 = assessRepository.findById(5L);
        Assertions.assertNotNull(assess1);

        List<Assess> assessList = assessRepository.findAll();
        Assertions.assertTrue(assessList.size()>0);

        assess.setRiskLevel(RiskLevels.earlyOnset);
        assess.setPatId(4L);
        Assertions.assertEquals(assess.getPatId(), 4L);
        Assertions.assertEquals(assess.getRiskLevel(), RiskLevels.earlyOnset);

    }



}
