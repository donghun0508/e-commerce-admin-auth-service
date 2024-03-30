package com.example.admin.auth.service.domain.valueobject;

import com.example.admin.auth.service.domain.exception.InvalidPasswordException;

public record Password(String value) {
    public void validate() {
        if(value.length() < 2 || value.length() > 10) {
            throw new InvalidPasswordException();
        }
    }
}
