package com.picpay_simplified.domain.useCases.Transaction.GetAllTransactionsUseCase;

import com.picpay_simplified.domain.entities.Transaction;

import java.util.List;

public interface GetAllTransactionsUseCase {
    public List<Transaction> execute();
}
