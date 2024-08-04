package com.ocsoares.crudspringboot.infrastructure.controllers.interfaces;

public interface IControllerWithArgument<R, P, E extends Exception> {
    R handle(P parameter) throws E;
}
