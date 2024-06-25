package com.picpay_simplified.infra.repositories;

import com.picpay_simplified.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
