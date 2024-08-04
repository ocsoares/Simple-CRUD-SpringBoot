package com.ocsoares.crudspringboot.infrastructure.persistence.repository.jpa;

import com.ocsoares.crudspringboot.infrastructure.persistence.entity.UserPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserPersistenceEntity, UUID> {
}
