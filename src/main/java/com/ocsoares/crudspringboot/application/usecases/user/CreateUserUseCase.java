package com.ocsoares.crudspringboot.application.usecases.user;

import com.ocsoares.crudspringboot.application.gateways.user.IUserRepositoryGateway;
import com.ocsoares.crudspringboot.application.usecases.interfaces.IUseCaseWithArgument;
import com.ocsoares.crudspringboot.application.usecases.response.UserResponse;
import com.ocsoares.crudspringboot.domain.entity.UserDomainEntity;
import com.ocsoares.crudspringboot.domain.exceptions.user.UserAlreadyExistsByEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase implements IUseCaseWithArgument<UserResponse, UserDomainEntity, UserAlreadyExistsByEmailException> {
    private final IUserRepositoryGateway userRepositoryGateway;

    @Override
    public UserResponse execute(UserDomainEntity parameter) throws UserAlreadyExistsByEmailException {
        // FAZER....
        return null;
    }
}
