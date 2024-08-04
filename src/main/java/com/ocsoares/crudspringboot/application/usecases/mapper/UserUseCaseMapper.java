package com.ocsoares.crudspringboot.application.usecases.mapper;

import com.ocsoares.crudspringboot.application.usecases.response.UserResponse;
import com.ocsoares.crudspringboot.domain.entity.UserDomainEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUseCaseMapper {
    public UserResponse toResponse(UserDomainEntity userDomainEntity) {
        return new UserResponse(userDomainEntity.name(), userDomainEntity.email());
    }

    public List<UserResponse> toResponseList(List<UserDomainEntity> userDomainEntityList) {
        return userDomainEntityList.stream().map(this::toResponse).toList();
    }
}
