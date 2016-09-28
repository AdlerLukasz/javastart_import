package pl.javastart.endpoint;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.javastart.model.User;

@Path("/users")
public class UserEndpoint {

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response saveUser(@Valid User user) {
    System.out.println(user);
    return Response.ok().build();
}
    
//@GET
//@Path("/{id}")
//public Response get(@Min(100) @PathParam("id") int id) {
//    User user = new User(id, "Example first", "Example last", "12345678");
//    System.out.println(user);
//    return Response.ok(user).build();
//}

@GET
@Path("/{id}")
@Produces(MediaType.TEXT_PLAIN)
@Valid
public User get(@Min(10) @PathParam("id") int id) {
    User user = new User(id, "Example first", "Example last", "12345678");
    return user;
}

//@GET
//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//public Response getForm(@Size(min=2) @FormParam("firstName") String firstName) {
//    System.out.println("fn " + firstName);
//    return null;
//}

}
