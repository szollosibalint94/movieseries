package com.epam.training.bmdb.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_USER("user", 1),
    ROLE_ADMIN("administrator", 2);

    private final String displayName;
    private final int priority;

    UserRole(String displayName, int priority) {
        this.displayName = displayName;
        this.priority = priority;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPriority() {
        return priority;
    }

    @Override public String getAuthority() {
        return name();
    }
}
