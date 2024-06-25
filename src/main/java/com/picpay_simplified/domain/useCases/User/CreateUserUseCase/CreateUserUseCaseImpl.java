package com.picpay_simplified.domain.useCases.User.CreateUserUseCase;

import com.picpay_simplified.application.dtos.User.UserRequestDto;
import com.picpay_simplified.domain.entities.User;
import com.picpay_simplified.domain.exceptions.User.EmailAlreadyExistsException;
import com.picpay_simplified.domain.exceptions.User.IdentificationAlreadyExistsException;
import com.picpay_simplified.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase{

    private final UserRepository userRepository;

    @Override
    public User execute(UserRequestDto userRequestDto) {
        this.VerifyUser(userRequestDto.email(), userRequestDto.identification());
        var user = new User();
        user.setName(userRequestDto.name());
        user.setEmail(userRequestDto.email());
        user.setUserType(userRequestDto.userType());
        user.setIdentification(userRequestDto.identification());
        user.setValueInWallet(userRequestDto.valueInWallet());
        user.setPassword(userRequestDto.password());
        return this.userRepository.save(user);
    }

    public void VerifyUser(String email, String identification){
        var userByEmail = this.userRepository.findByEmail(email).isPresent();
        if(userByEmail)
            throw new EmailAlreadyExistsException("Já existe um usuário com esse email!");

        var userByIdentification = this.userRepository.findByIdentification(identification).isPresent();
        if(userByIdentification)
            throw new IdentificationAlreadyExistsException("Já existe um usuário com essa identificação!");
    }
}
