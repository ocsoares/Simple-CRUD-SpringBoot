package com.ocsoares.crudspringboot.infrastructure.controllers.user.mappers;

import com.ocsoares.crudspringboot.domain.entity.UserDomainEntity;
import com.ocsoares.crudspringboot.infrastructure.controllers.user.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserControllerMapper {
    public UserDomainEntity toDomain(UserDTO userDTO) {
        return new UserDomainEntity(userDTO.name(), userDTO.email(), userDTO.password());
    }
}
