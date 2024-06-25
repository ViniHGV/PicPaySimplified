package com.picpay_simplified.domain.exceptions.User;

public class IdentificationAlreadyExistsException extends RuntimeException{
    public IdentificationAlreadyExistsException(String message){
        super(message);
    }
}
