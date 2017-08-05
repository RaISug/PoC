package com.radoslav.bvalidation.ft.dinjection.exception.mappers;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class BeanValidationExceptionMapper implements ExceptionMapper<ValidationException> {

  @Override
  public Response toResponse(ValidationException exception) {
    traceException((ConstraintViolationException) exception);

    return Response
        .status(HttpServletResponse.SC_BAD_REQUEST)
        .entity("{'description':'validation exception occur while processing your request'}")
        .build();
  }

  public void traceException(ConstraintViolationException exception) {
    Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();

    Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
    while (iterator.hasNext()) {
      ConstraintViolation<?> violation = iterator.next();

      System.out.println(violation.getPropertyPath().toString().replace("test.", "") + " " + violation.getMessage());
    }
  }
}
