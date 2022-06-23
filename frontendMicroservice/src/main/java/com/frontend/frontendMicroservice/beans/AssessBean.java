package com.frontend.frontendMicroservice.beans;

public class AssessBean {

    private Long patId;
    private RiskLevelsBean riskLevel;

    public AssessBean(Long patId, RiskLevelsBean riskLevel) {
        this.patId = patId;
        this.riskLevel = riskLevel;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public RiskLevelsBean getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevelsBean riskLevel) {
        this.riskLevel = riskLevel;
    }
}
