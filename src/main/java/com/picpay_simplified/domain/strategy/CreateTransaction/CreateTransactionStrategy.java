package com.picpay_simplified.domain.strategy.CreateTransaction;

import com.picpay_simplified.domain.entities.User;

import java.math.BigDecimal;

public interface CreateTransactionStrategy {
    void execute(User payer, User receiver, BigDecimal valueTransaction);
}
