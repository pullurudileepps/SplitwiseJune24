package com.example.SplitwiseJune24.Exceptions;

public class InvalidRegisterUserRequest extends RuntimeException {
    public InvalidRegisterUserRequest(String message) {
        super(message);
    }
}
