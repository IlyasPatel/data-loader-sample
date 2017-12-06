package com.efinancialcareers.enums;


public enum YearsExperience {

    NO_EXPERIENCE(1, "No experience"),
    ONE_THREE_YEARS_EXPERIENCE(2, "1-3 yrs"),
    THREE_FIVE_YEARS_EXPERIENCE(3, "3-5"),
    FIVE_SEVEN_YEARS_EXPERIENCE(4, "5-7"),
    SEVEN_TEN_YEARS_EXPERIENCE(5, "7-10"),
    TEN_FIFTEEN_YEARS_EXPERIENCE(6, "10-15"),
    MORE_THAN_FIFTEEN_YEARS_EXPERIENCE(7, "15+");

    private final String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    private YearsExperience(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public static YearsExperience getDefault() {
        return YearsExperience.NO_EXPERIENCE;
    }
}
