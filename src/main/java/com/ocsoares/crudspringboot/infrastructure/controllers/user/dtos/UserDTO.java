package com.ocsoares.crudspringboot.infrastructure.controllers.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(@NotBlank(message = "The name is required") String name,
                      @NotBlank(message = "The email is required") @Email(message = "Must be a valid email address") String email,
                      @NotBlank(message = "The password is required") String password) {
}
