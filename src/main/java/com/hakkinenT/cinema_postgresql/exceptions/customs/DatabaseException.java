package com.hakkinenT.cinema_postgresql.exceptions.customs;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String message) {
        super(message);
    }
}
