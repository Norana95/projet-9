package com.projet9.assess.repository;

import com.projet9.assess.model.Assess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessRepository extends JpaRepository<Assess, Long> {
}
