package com.picpay_simplified.domain.useCases.User.GetAllUsersUseCase;

import com.picpay_simplified.domain.entities.User;

import java.util.List;

public interface GetAllUsersUseCase {
    public List<User> execute();
}
