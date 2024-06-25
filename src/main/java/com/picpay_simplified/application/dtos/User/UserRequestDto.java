package com.picpay_simplified.application.dtos.User;

import com.picpay_simplified.domain.enums.UserTypes;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record UserRequestDto(
        String name,
        @Length(min = 11, max = 11, message = "Número de identificação inválido!")
        String identification,
        @Email(message = "E-mail Inválido!")
        String email,
        String password,
        BigDecimal valueInWallet,
        UserTypes userType) {
}
