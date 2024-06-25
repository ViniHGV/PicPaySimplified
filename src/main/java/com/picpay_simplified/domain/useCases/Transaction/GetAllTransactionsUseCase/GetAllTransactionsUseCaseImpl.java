package com.picpay_simplified.domain.useCases.Transaction.GetAllTransactionsUseCase;

import com.picpay_simplified.domain.entities.Transaction;
import com.picpay_simplified.infra.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class GetAllTransactionsUseCaseImpl implements GetAllTransactionsUseCase {

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> execute() {
        return this.transactionRepository.findAll();
    }
}
