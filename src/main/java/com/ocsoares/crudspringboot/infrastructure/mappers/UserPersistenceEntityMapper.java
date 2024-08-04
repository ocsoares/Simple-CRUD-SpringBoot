package com.ocsoares.crudspringboot.infrastructure.mappers;

import com.ocsoares.crudspringboot.domain.entity.UserDomainEntity;
import com.ocsoares.crudspringboot.infrastructure.persistence.entity.UserPersistenceEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserPersistenceEntityMapper {
    public UserPersistenceEntity toPersistence(UserDomainEntity userDomainEntity) {
        return new UserPersistenceEntity(userDomainEntity.name(), userDomainEntity.email(),
                userDomainEntity.password()
        );
    }

    public UserDomainEntity toDomain(UserPersistenceEntity userPersistenceEntity) {
        return new UserDomainEntity(userPersistenceEntity.getName(), userPersistenceEntity.getEmail(),
                userPersistenceEntity.getPassword()
        );
    }

    public List<UserDomainEntity> toDomainList(List<UserPersistenceEntity> userPersistenceEntityList) {
        return userPersistenceEntityList.stream().map(this::toDomain).toList();
    }
}
