package com.efinancialcareers.enums;

public enum Title {

    MR(1),
    MRS(2),
    MS(3),
    DR(4),
    PROF(5),
    OTHER(6);

    private final int titleId;

    private Title(int id) {
        titleId = id;
    }

    public Integer getId() {
        return titleId;
    }
}
