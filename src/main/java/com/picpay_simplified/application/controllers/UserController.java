package com.picpay_simplified.application.controllers;

import com.picpay_simplified.application.dtos.User.UserRequestDto;
import com.picpay_simplified.domain.entities.User;
import com.picpay_simplified.domain.useCases.User.CreateUserUseCase.CreateUserUseCase;
import com.picpay_simplified.domain.useCases.User.GetAllUsersUseCase.GetAllUsersUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Criar usuário",
            description = "Endpoint reponsável pela criação de usuários")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema =  @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserRequestDto userRequestDto){
        try{
            return ResponseEntity.status(201).body(this.createUserUseCase.execute(userRequestDto));
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @Operation(summary = "Visualizar Usuários cadastrados",
            description = "Endpoint reponsável pela Visualizar de usuários cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content (mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = User.class)))}),
            @ApiResponse(responseCode = "404",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(this.getAllUsersUseCase.execute());
    }
}
