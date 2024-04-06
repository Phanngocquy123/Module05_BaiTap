package com.crud.bai3.exception;

public class NotFoundEntityException extends Exception{
    public NotFoundEntityException(String message) {
        super(message);
    }
}