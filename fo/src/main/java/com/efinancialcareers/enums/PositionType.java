package com.efinancialcareers.enums;

public enum PositionType {

    PERMANENT(1),
    TEMPORARY(2),
    CONTRACT(3),
    SELF_EMPLOYED(4),
    INTERNSHIPS_AND_GRADUATE_TRAINEE(5);

    private Integer id;

    public Integer getId() {
        return id;
    }

    private PositionType(Integer id) {
        this.id = id;
    }
}
