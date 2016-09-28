package pl.javastart.jaxrs.endpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/test")
public class SimpleEndpoint {

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "asdf";
    }
    
}
