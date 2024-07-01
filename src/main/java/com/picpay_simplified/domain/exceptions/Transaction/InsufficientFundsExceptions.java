package com.picpay_simplified.domain.exceptions.Transaction;

public class InsufficientFundsExceptions extends RuntimeException{
    public InsufficientFundsExceptions(String message){
        super(message);
    }
}
