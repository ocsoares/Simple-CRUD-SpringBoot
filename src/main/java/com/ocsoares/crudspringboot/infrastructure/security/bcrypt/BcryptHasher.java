package com.ocsoares.crudspringboot.infrastructure.security.bcrypt;

import com.ocsoares.crudspringboot.domain.security.IPasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BcryptHasher implements IPasswordHasher {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String hash(String plainPassword) {
        return this.bCryptPasswordEncoder.encode(plainPassword);
    }

    @Override
    public String hash(String plainPassword, Integer salt) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Hashing with manual salt is not supported !");
    }

    @Override
    public Boolean compare(String plainPassword, String hashedPassword) {
        return this.bCryptPasswordEncoder.matches(plainPassword, hashedPassword);
    }
}
