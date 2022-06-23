package com.projet9.patientmicroservice.web.controller;

import com.projet9.patientmicroservice.configuration.PatientNotFoundException;
import com.projet9.patientmicroservice.model.Patient;
import com.projet9.patientmicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController //indique que les données renvoyées par chaque méthode seront
// écrites directement dans le corps de la réponse au lieu d'afficher un modèle.
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/patient/add")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient newPatient) {
        Patient patientAdded = patientRepository.save(newPatient);
        if(!patientRepository.existsById(newPatient.getId())){
            patientRepository.save(newPatient);
            return ResponseEntity.ok(newPatient);
        }
        return null;
    }

    @GetMapping("/patients")
    List<Patient> allPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    Patient getPatientbyId(@PathVariable("id") Long id) {

        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }

    @PostMapping("/patient/update/{id}")
    Patient replacePatient(@RequestBody Patient newPatient, @PathVariable("id") Long id) {

        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setFamily(newPatient.getFamily());
                    patient.setGiven(newPatient.getGiven());
                    patient.setAddress(newPatient.getAddress());
                    patient.setPhone(newPatient.getPhone());
                    patient.setSex(newPatient.getSex());
                    patient.setDob(newPatient.getDob());
                    return patientRepository.save(patient);
                })
                .orElseGet(() -> {
                    newPatient.setId(id);
                    return patientRepository.save(newPatient);
                });
    }
}
