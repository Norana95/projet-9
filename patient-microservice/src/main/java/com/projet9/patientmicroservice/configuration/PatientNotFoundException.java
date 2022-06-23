package com.projet9.patientmicroservice.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus qui définit le code de statut associé à l'exception.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException  {
    public PatientNotFoundException(Long id) {
        super("Could not find patient " + id);
    }
}
