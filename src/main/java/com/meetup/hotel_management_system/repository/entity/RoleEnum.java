package com.meetup.hotel_management_system.repository.entity;

public enum RoleEnum {

    GUEST("GUEST"),
    STAFF("STAFF"),
    MANAGER("MANAGER");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
