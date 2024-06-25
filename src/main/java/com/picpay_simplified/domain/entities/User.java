package com.picpay_simplified.domain.entities;

import com.picpay_simplified.domain.enums.UserTypes;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String identification;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private BigDecimal valueInWallet;

    private UserTypes userType;

    public void debitValue(BigDecimal value){
        this.setValueInWallet(this.getValueInWallet().subtract(value));
    }

    public void creditValue(BigDecimal value){
        this.setValueInWallet(this.getValueInWallet().add(value));
    }
}
