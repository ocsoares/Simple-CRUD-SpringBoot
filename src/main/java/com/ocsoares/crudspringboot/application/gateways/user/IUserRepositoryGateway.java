package com.ocsoares.crudspringboot.application.gateways.user;

import com.ocsoares.crudspringboot.domain.entity.UserDomainEntity;

import java.util.Optional;

public interface IUserRepositoryGateway {
    UserDomainEntity createUser(UserDomainEntity userDomainEntity);
    Optional<UserDomainEntity> findUserByEmail(String email);
}
