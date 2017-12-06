package com.efinancialcareers.enums;

public enum EmploymentType {

    FULL_TIME(1),
    PART_TIME(2);

    private Integer id;

    public Integer getId() {
        return id;
    }

    private EmploymentType(Integer id) {
        this.id = id;
    }
}
