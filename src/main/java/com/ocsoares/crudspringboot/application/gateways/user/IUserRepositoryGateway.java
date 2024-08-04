package com.ocsoares.crudspringboot.application.gateways.user;

import com.ocsoares.crudspringboot.domain.entity.UserDomainEntity;

public interface IUserRepositoryGateway {
    UserDomainEntity createUser(UserDomainEntity userDomainEntity);
}
