package com.efinancialcareers.enums;

public enum SalaryBand {

    FIRST_TIER(1),

    SECOND_TIER(2),

    THIRD_TIER(3),

    FOURTH_TIER(4),

    FIFTH_TIER(5),

    SIXTH_TIER(6),

    SEVENTH_TIER(7);

    private Integer id;

    private SalaryBand(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
