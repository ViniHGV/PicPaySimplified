package com.picpay_simplified.domain.useCases.Transaction.CreateTransactionUseCase;

import com.picpay_simplified.application.dtos.Transaction.TransactionRequestDto;
import com.picpay_simplified.domain.entities.Transaction;

public interface CreateTransactionUseCase {
    public Transaction execute(TransactionRequestDto transactionRequestDto);
}
