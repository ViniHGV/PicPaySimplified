package com.picpay_simplified.domain.entities;

import com.picpay_simplified.domain.enums.UserTypes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
