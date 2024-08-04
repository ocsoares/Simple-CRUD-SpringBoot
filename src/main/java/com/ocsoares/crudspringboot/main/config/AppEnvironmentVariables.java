package com.ocsoares.crudspringboot.main.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Component
public class AppEnvironmentVariables {
    @NotBlank
    @Value("${DB_USER}")
    private String dbUser;

    @NotBlank
    @Value("${DB_PASSWORD}")
    private String dbPassword;

    @NotBlank
    @Value("${DB_NAME}")
    private String dbName;

    @NotBlank
    @Value("${DB_URL}")
    private String dbUrl;
}
