package com.ocsoares.crudspringboot.application.usecases.user;

import com.ocsoares.crudspringboot.application.gateways.user.IUserRepositoryGateway;
import com.ocsoares.crudspringboot.application.usecases.interfaces.IUseCaseWithArgument;
import com.ocsoares.crudspringboot.application.usecases.mapper.UserUseCaseMapper;
import com.ocsoares.crudspringboot.application.usecases.response.UserResponse;
import com.ocsoares.crudspringboot.domain.entity.UserDomainEntity;
import com.ocsoares.crudspringboot.domain.exceptions.user.UserAlreadyExistsByEmailException;
import com.ocsoares.crudspringboot.domain.security.IPasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase implements IUseCaseWithArgument<UserResponse, UserDomainEntity, UserAlreadyExistsByEmailException> {
    private final IUserRepositoryGateway userRepositoryGateway;
    private final IPasswordHasher passwordHasher;
    private final UserUseCaseMapper userUseCaseMapper;

    @Override
    public UserResponse execute(UserDomainEntity userDomainEntity) throws UserAlreadyExistsByEmailException {
        Optional<UserDomainEntity> userByEmail = this.userRepositoryGateway.findUserByEmail(userDomainEntity.email());

        if (userByEmail.isPresent()) {
            throw new UserAlreadyExistsByEmailException();
        }

        String hashedPassword = this.passwordHasher.hash(userDomainEntity.password());

        var userWithHashedPassword = new UserDomainEntity(userDomainEntity.name(), userDomainEntity.email(),
                hashedPassword
        );

        UserDomainEntity createdUser = this.userRepositoryGateway.createUser(userWithHashedPassword);

        return this.userUseCaseMapper.toResponse(createdUser);
    }
}
