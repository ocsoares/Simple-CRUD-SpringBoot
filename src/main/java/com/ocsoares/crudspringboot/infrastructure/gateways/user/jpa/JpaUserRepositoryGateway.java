package com.ocsoares.crudspringboot.infrastructure.gateways.user.jpa;

import com.ocsoares.crudspringboot.application.gateways.user.IUserRepositoryGateway;
import com.ocsoares.crudspringboot.domain.entity.UserDomainEntity;
import com.ocsoares.crudspringboot.infrastructure.mappers.UserPersistenceEntityMapper;
import com.ocsoares.crudspringboot.infrastructure.persistence.entity.UserPersistenceEntity;
import com.ocsoares.crudspringboot.infrastructure.persistence.repository.jpa.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaUserRepositoryGateway implements IUserRepositoryGateway {
    private final JpaUserRepository jpaUserRepository;
    private final UserPersistenceEntityMapper userPersistenceEntityMapper;

    @Override
    public UserDomainEntity createUser(UserDomainEntity userDomainEntity) {
        UserPersistenceEntity userPersistenceEntity = this.userPersistenceEntityMapper.toPersistence(userDomainEntity);

        this.jpaUserRepository.save(userPersistenceEntity);

        return this.userPersistenceEntityMapper.toDomain(userPersistenceEntity);
    }

    @Override
    public Optional<UserDomainEntity> findUserByEmail(String email) {
        Optional<UserPersistenceEntity> userByEmail = this.jpaUserRepository.findByEmail(email);

        if (userByEmail.isPresent()) {
            UserPersistenceEntity userPersistenceEntity = userByEmail.get();
            UserDomainEntity userDomainEntity = this.userPersistenceEntityMapper.toDomain(userPersistenceEntity);

            return Optional.of(userDomainEntity);
        }

        return Optional.empty();
    }
}