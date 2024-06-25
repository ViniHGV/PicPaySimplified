package com.picpay_simplified.application.controllers;

import com.picpay_simplified.application.dtos.User.UserRequestDto;
import com.picpay_simplified.domain.useCases.User.CreateUserUseCase.CreateUserUseCase;
import com.picpay_simplified.domain.useCases.User.GetAllUsersUseCase.GetAllUsersUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserRequestDto userRequestDto){
        try{
            return ResponseEntity.status(201).body(this.createUserUseCase.execute(userRequestDto));
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(this.getAllUsersUseCase.execute());
    }
}
