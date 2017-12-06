package com.efinancialcareers.enums;

public enum EducationLevel {

    /**
     * Not specified
     */
    EDUCATION_LEVEL_1(1),

    /**
     * High School
     */
    EDUCATION_LEVEL_2(2),

    /**
     * Certificate/Diploma
     */
    EDUCATION_LEVEL_3(3),

    /**
     * Associate Degree
     */
    EDUCATION_LEVEL_4(4),

    /**
     * 3 or 4 yr. Undergraduate degree
     */
    EDUCATION_LEVEL_5(5),

    /**
     * Postgraduate Degree
     */
    EDUCATION_LEVEL_6(6),

    /**
     * Postgraduate Degree - MBA
     */
    EDUCATION_LEVEL_7(7),

    /**
     * Postgraduate Degree - Masters
     */
    EDUCATION_LEVEL_8(8),

    /**
     * Postgraduate Degree - JD
     */
    EDUCATION_LEVEL_9(9),

    /**
     * Postgraduate Degree - PhD/Doctorate
     */
    EDUCATION_LEVEL_10(10),

    /**
     * Other Degree
     */
    EDUCATION_LEVEL_11(11);

    private final Integer educationLevelId;


    private EducationLevel(Integer id) {
        educationLevelId = id;
    }

    public Integer getId() {
        return educationLevelId;
    }
}
