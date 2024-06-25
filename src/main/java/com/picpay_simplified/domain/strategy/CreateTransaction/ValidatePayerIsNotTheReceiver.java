package com.picpay_simplified.domain.strategy.CreateTransaction;

import com.picpay_simplified.domain.entities.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidatePayerIsNotTheReceiver implements CreateTransactionStrategy{
    @Override
    public void execute(User payer, User receiver, BigDecimal valueTransaction) {
        if(payer.equals(receiver))
            throw new RuntimeException("Não é possível fazer transações para si próprio!");
    }
}
