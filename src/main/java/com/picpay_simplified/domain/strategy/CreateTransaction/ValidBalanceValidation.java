package com.picpay_simplified.domain.strategy.CreateTransaction;

import com.picpay_simplified.domain.entities.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidBalanceValidation implements  CreateTransactionStrategy{
    @Override
    public void execute(User payer, User receiver, BigDecimal valueTransaction) {
        if(payer.getValueInWallet().compareTo(valueTransaction) < 0)
            throw new RuntimeException("Saldo inválido!");
    }
}
