package com.picpay_simplified.domain.strategy.CreateTransaction;

import com.picpay_simplified.domain.entities.User;
import com.picpay_simplified.domain.enums.UserTypes;
import com.picpay_simplified.domain.exceptions.Transaction.TypeUserException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TypeUserValidation implements CreateTransactionStrategy{
    @Override
    public void execute(User payer,User receiver, BigDecimal valueTransaction) {
        if(!payer.getUserType().equals(UserTypes.comum))
            throw new TypeUserException("Lojistas não criam transações!");
    }
}
