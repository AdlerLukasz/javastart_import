package com.example;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException ex) {
        System.out.println(ex.getMessage());
        return Response.ok("I feel bad :( " + ex.getCause()).build();
    }

}