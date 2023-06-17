package com.example.denSooluk.Entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN,  RECEPTIONIST, STAFF;

    @Override
    public String getAuthority() {
        return name();
    }

}