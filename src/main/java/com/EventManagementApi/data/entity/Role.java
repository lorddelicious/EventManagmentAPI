package com.EventManagementApi.data.entity;

/**
 * Created by Shravan Deolalikar on 1/19/2017.
 */
public enum Role {
    SUPER_ADMIN, VENUE_ADMIN, VENUE_EMPLOYEE, PROMOTER, ATTENDEE;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
