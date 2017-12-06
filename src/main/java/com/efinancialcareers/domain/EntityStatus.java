package com.efinancialcareers.domain;

public enum EntityStatus {

    ACTIVE(1),
    INACTIVE(2),
    LOCKED(3),
    DELETED(4),
    PENDING(5);

    private Integer id;

    private EntityStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
