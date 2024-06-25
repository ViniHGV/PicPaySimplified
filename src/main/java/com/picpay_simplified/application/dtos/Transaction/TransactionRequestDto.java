package com.picpay_simplified.application.dtos.Transaction;

import com.picpay_simplified.domain.entities.User;

import java.math.BigDecimal;

public record TransactionRequestDto(
        Integer payer,
        Integer receiver,
        BigDecimal value) {
}
