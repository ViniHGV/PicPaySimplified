package com.picpay_simplified.domain.exceptions.Transaction;

public class PayerIsNotTheReceiverException extends RuntimeException{
    public PayerIsNotTheReceiverException(String message){
        super(message);
    }
}
