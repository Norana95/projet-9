package com.projet9.assess.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Assess {
    @Id
    private Long patId;
    private RiskLevels riskLevel;

    public Assess() {
    }

    public Assess(Long patId, RiskLevels riskLevel) {
        this.patId = patId;
        this.riskLevel = riskLevel;
    }

    public RiskLevels getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevels riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }
}
