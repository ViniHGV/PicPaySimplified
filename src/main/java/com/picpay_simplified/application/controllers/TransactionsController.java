package com.picpay_simplified.application.controllers;

import com.picpay_simplified.application.dtos.Transaction.TransactionRequestDto;
import com.picpay_simplified.domain.entities.Transaction;
import com.picpay_simplified.domain.useCases.Transaction.CreateTransactionUseCase.CreateTransactionUseCase;
import com.picpay_simplified.domain.useCases.Transaction.GetAllTransactionsUseCase.GetAllTransactionsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionsController {

    private final CreateTransactionUseCase createTransactionUseCase;
    private final GetAllTransactionsUseCase getAllTransactionsUseCase;

    @Operation(summary = "Criar transação",
    description = "Endpoint reponsável pela criação de transações entre usuários")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content (mediaType = "application/json",
                    schema = @Schema(implementation = Transaction.class))}),
            @ApiResponse(responseCode = "404",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity createTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        try{
            return ResponseEntity.status(201).body(this.createTransactionUseCase.execute(transactionRequestDto));
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @Operation(summary = "Visualizar transações",
            description = "Endpoint reponsável pela Visualizar de transações")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content (mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Transaction.class)))}),
            @ApiResponse(responseCode = "404",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity getAllTransactions(){
        return ResponseEntity.ok(this.getAllTransactionsUseCase.execute());
    }
}
