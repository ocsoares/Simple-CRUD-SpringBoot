package com.ocsoares.crudspringboot.domain.security;

public interface IPasswordHasher {
    String hash(String plainPassword);
    String hash(String plainPassword, Integer salt);
    Boolean compare(String plainPassword, String hashedPassword);
}
