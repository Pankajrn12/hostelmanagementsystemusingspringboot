package com.hostal.hostelManagementSystem.status;

public enum AvailabilityStatus {
    Available("Available"),
    Booked("Booked")
    ;
    private String description;
    AvailabilityStatus(String description) {
        this.description = description;
    }
}
