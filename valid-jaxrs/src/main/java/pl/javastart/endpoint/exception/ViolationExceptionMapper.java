package pl.javastart.endpoint.exception;

import javax.validation.ValidationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.api.validation.ResteasyViolationException;

@Provider
public class ViolationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException e) {
        if(e instanceof ResteasyViolationException) {
            ResteasyViolationException re = (ResteasyViolationException) e;
            //w tym miejscu mo¿emy wyci¹gn¹æ informacje o z³amanych ograniczeniach
            //w parametrach, zwracanych obiektach, czy komunikaty
            return Response.status(Status.BAD_REQUEST).entity("RestEasy says sorry").build();
        } else {
            return Response.status(Status.BAD_REQUEST).entity("sorry").build();
        }
    }
}