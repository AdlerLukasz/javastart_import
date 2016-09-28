package pl.javastart.jaxrs.endpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/form")
@RequestScoped
public class FormEndpoint {
    @POST
    public Response consumeMessage(@FormParam("message") String message, 
                                   @FormParam("number") Integer number) {
        return Response.ok(message + " " + number).build();
    }
}
