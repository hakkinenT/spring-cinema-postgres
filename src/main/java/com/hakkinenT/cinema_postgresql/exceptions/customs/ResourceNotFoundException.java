package com.hakkinenT.cinema_postgresql.exceptions.customs;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
