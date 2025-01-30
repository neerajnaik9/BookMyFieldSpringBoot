package com.bookmyfield.BookMyFieldBackend.dto;

public class AuthResponse {

    private String message;  // For signup response
    private String token;    // For login response
    private String role;

    // Default Constructor
    public AuthResponse() {}

    // Constructor for login response (returns token & role)
    public AuthResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    // Constructor for signup response (returns success message)
    public AuthResponse(String message) {
        this.message = message;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setMessage(String message) {
        this.message = message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
