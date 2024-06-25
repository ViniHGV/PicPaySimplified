package com.picpay_simplified.application.controllers;

import com.picpay_simplified.application.dtos.Transaction.TransactionRequestDto;
import com.picpay_simplified.domain.useCases.Transaction.CreateTransactionUseCase.CreateTransactionUseCase;
import com.picpay_simplified.domain.useCases.Transaction.GetAllTransactionsUseCase.GetAllTransactionsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionsController {

    private final CreateTransactionUseCase createTransactionUseCase;
    private final GetAllTransactionsUseCase getAllTransactionsUseCase;

    @PostMapping
    public ResponseEntity createTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        try{
            return ResponseEntity.status(201).body(this.createTransactionUseCase.execute(transactionRequestDto));
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAllTransactions(){
        return ResponseEntity.ok(this.getAllTransactionsUseCase.execute());
    }
}
