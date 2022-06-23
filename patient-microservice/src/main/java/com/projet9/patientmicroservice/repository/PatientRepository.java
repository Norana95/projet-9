package com.projet9.patientmicroservice.repository;

import com.projet9.patientmicroservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// interface qui étend spring data jpa <type de domaine, type d'id>
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
