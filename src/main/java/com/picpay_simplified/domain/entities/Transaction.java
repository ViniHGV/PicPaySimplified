package com.picpay_simplified.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transactions")
@Data
@NoArgsConstructor
public class Transaction {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private User payer;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Column(nullable = false)
    private BigDecimal value;

    @DateTimeFormat
    private LocalDateTime realizedAt;

    public Transaction(User payer, User receiver, BigDecimal value){
        this.payer = payer;
        this.receiver = receiver;
        this.value = value;
        this.realizedAt = LocalDateTime.now();
    }
}
