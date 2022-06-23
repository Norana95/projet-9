package com.projet9.patientmicroservice;

import com.projet9.patientmicroservice.model.Patient;
import com.projet9.patientmicroservice.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientMicroserviceApplicationTests {

	@Autowired
	PatientRepository repository;

	@Test
	void testCrudPatient() {
		Patient patient = new Patient("testFirstname", "testLastname", new Date(25/5/1993), "testSex", "testAddress", "testPhone");

		// Save
		patient = repository.save(patient);
		assertNotNull(patient.getId());
		assertEquals("testFirstname", patient.getFamily());



		// Update
		patient.setFamily("x");
		patient = repository.save(patient);
		assertEquals("x", patient.getFamily());

		// Find
		List<Patient> patientList = repository.findAll();
		assertTrue(patientList.size() > 0);

		// Find by id
		Optional<Patient> patientId = repository.findById(patient.getId());
		assertEquals(patientId.get().getId(), patient.getId());

		// Delete
		Long id = patient.getId();
		repository.delete(patient);
		Optional<Patient> optionalPatient = repository.findById(id);
		assertFalse(optionalPatient.isPresent());
	}

}
