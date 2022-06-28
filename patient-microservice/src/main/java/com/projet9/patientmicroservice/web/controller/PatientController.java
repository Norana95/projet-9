package com.projet9.patientmicroservice.web.controller;

import com.projet9.patientmicroservice.model.Patient;
import com.projet9.patientmicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController //indique que les données renvoyées par chaque méthode seront
// écrites directement dans le corps de la réponse au lieu d'afficher un modèle.
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/patient/add")
    public ResponseEntity<String> createPatient(@RequestBody Patient newPatient) {
        Patient patientAdded = patientRepository.save(newPatient);
        return ResponseEntity.ok("ce patient a été ajouté " + newPatient);
    }

    @GetMapping("/patients")
    List<Patient> allPatients() {
        List<Patient> patients = patientRepository.findAll();
        patients.size();
        return patients;
    }

    @GetMapping("/patients/{id}")
    Optional<Patient> getPatientbyId(@PathVariable("id") Long id) {
        return patientRepository.findById(id);
    }

    @PostMapping("/patient/update/{id}")
    ResponseEntity<String> replacePatient(@RequestBody Patient newPatient, @PathVariable("id") Long id) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setFamily(newPatient.getFamily());
                    patient.setGiven(newPatient.getGiven());
                    patient.setAddress(newPatient.getAddress());
                    patient.setPhone(newPatient.getPhone());
                    patient.setSex(newPatient.getSex());
                    patient.setDob(newPatient.getDob());
                    patientRepository.save(patient);
                    return ResponseEntity.ok("les infos ont été modifié");
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("ce patient n'existe pas"));
    }
}
