package com.ocsoares.crudspringboot.infrastructure.controllers.user;

import com.ocsoares.crudspringboot.application.usecases.response.UserResponse;
import com.ocsoares.crudspringboot.application.usecases.user.CreateUserUseCase;
import com.ocsoares.crudspringboot.domain.entity.UserDomainEntity;
import com.ocsoares.crudspringboot.domain.exceptions.user.UserAlreadyExistsByEmailException;
import com.ocsoares.crudspringboot.infrastructure.controllers.interfaces.IControllerWithArgument;
import com.ocsoares.crudspringboot.infrastructure.controllers.user.dtos.UserDTO;
import com.ocsoares.crudspringboot.infrastructure.controllers.user.mappers.UserControllerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CreateUserController implements IControllerWithArgument<UserResponse, UserDTO, Exception> {
    private final CreateUserUseCase createUserUseCase;
    private final UserControllerMapper userControllerMapper;

    @Override
    @PostMapping("email")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserResponse handle(@RequestBody @Valid UserDTO userDTO) throws UserAlreadyExistsByEmailException {
        UserDomainEntity userDomainEntity = this.userControllerMapper.toDomain(userDTO);

        return this.createUserUseCase.execute(userDomainEntity);
    }
}
