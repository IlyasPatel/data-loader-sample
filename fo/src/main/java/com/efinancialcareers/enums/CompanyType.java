package com.efinancialcareers.enums;

public enum CompanyType {

    DIRECT_EMPLOYER(1),
    RECRUITMENT_AGENCY(2),
    RPO(3),
    AD_AGENCY(4);

    private Integer id;

    private CompanyType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
