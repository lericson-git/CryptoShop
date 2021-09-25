package com.example.cryptoshop_backend.utils;

public class LoginValidators {
    private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isEmailValid (String email) {
        return email.matches(EMAIL_PATTERN);
    }
}
