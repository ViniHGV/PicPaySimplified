package com.picpay_simplified.domain.useCases.User.GetAllUsersUseCase;

import com.picpay_simplified.domain.entities.User;
import com.picpay_simplified.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

    private final UserRepository userRepository;

    @Override
    public List<User> execute() {
        return this.userRepository.findAll();
    }
}
