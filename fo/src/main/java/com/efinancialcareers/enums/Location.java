package com.efinancialcareers.enums;

public enum Location {

    LONDON(2643743),
    GLOBAL(-1);

    private long locationId;

    private Location(int locationId) {
        this.locationId = locationId;
    }

    public long getLocationId() {
        return locationId;
    }
}
