package com.efinancialcareers.enums;

public enum InventoryType {

    SLOT(1),
    CREDIT(2);

    private final Integer id;

    InventoryType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
