package com.efinancialcareers.enums;

public enum EntityStatus {
    ACTIVE(1),
    INACTIVE(2),
    LOCKED(3),
    DELETED(4),
    PENDING(5),
    DEFAULT_INVALID_VALUE(0);

    private Integer id;

    private EntityStatus(Integer id) {
        this.id = id;
    }
}
