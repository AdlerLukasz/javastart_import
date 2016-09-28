package pl.javastart.rest;

import java.time.LocalTime;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/hello")
public class HelloEndpoint {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHello() {
        return "Hello " + LocalTime.now();
    }
    
}
