package com.picpay_simplified.domain.useCases.User.CreateUserUseCase;

import com.picpay_simplified.application.dtos.User.UserRequestDto;
import com.picpay_simplified.domain.entities.User;

public interface CreateUserUseCase {
    public User execute(UserRequestDto userRequestDto);
}
