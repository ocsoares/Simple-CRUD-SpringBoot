package com.ocsoares.crudspringboot.domain.exceptions.response;

public record InvalidRequestBodyException(String field, String message) {
}
