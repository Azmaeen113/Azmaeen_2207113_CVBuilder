package com.cvbuilder.utils;

import java.util.regex.Pattern;

/**
 * Utility class for form validation
 */
public class ValidationUtils {

    private static final String EMAIL_PATTERN = 
        "^[A-Za-z0-9+_.-]+@(.+)$";
    
    private static final String PHONE_PATTERN = 
        "^[0-9+\\-\\s()]{7,}$";

    /**
     * Validate email format
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    /**
     * Validate phone number format (at least 7 digits, can include spaces, dashes, parentheses, +)
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches(PHONE_PATTERN, phoneNumber);
    }

    /**
     * Check if string is empty or null
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Validate required field
     */
    public static boolean isValidRequired(String field) {
        return !isEmpty(field);
    }
}
