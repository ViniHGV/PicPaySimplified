package com.picpay_simplified.domain.useCases.Transaction.CreateTransactionUseCase;

import com.picpay_simplified.application.authorizeTransaction.AuthorizeTransaction;
import com.picpay_simplified.application.dtos.Transaction.TransactionRequestDto;
import com.picpay_simplified.domain.entities.Transaction;
import com.picpay_simplified.domain.enums.UserTypes;
import com.picpay_simplified.domain.strategy.CreateTransaction.CreateTransactionStrategy;
import com.picpay_simplified.infra.repositories.TransactionRepository;
import com.picpay_simplified.infra.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase{

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final AuthorizeTransaction authorizeTransaction;
    private List<CreateTransactionStrategy> createTransactionStrategyList;

    @Override
    @Transactional
    public Transaction execute(TransactionRequestDto transactionRequestDto) {
        var payer = this.userRepository.findById(transactionRequestDto.payer()).orElseThrow(
                () -> new RuntimeException("Usuário inválido!")
        );

        var receiver = this.userRepository.findById(transactionRequestDto.receiver()).orElseThrow(
                () -> new RuntimeException("Usuário inválido!")
        );

        this.createTransactionStrategyList.forEach(validations ->
                validations.execute(payer, receiver, transactionRequestDto.value())
        );

        payer.debitValue(transactionRequestDto.value());
        this.userRepository.save(payer);

        receiver.creditValue(transactionRequestDto.value());
        this.userRepository.save(receiver);

        this.authorizeTransaction.execute();

        var transaction = new Transaction(payer, receiver, transactionRequestDto.value());

        return this.transactionRepository.save(transaction) ;
    }
}
