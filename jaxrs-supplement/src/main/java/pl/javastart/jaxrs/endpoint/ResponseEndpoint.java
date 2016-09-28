package pl.javastart.jaxrs.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import pl.javastart.jaxrs.model.Book;

@Path("/example")
public class ResponseEndpoint {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Book book) {
        //zapisujemy obiekt w bazie
        return Response.ok().build();
    }
    
    @GET
    @Path("/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("isbn") 
                        @DefaultValue("1234") String isbn) {
        if("1234".equals(isbn)) {
            //nie odnaleziono
            return Response
                    .status(404)
                    .build();
        } else {
            //odnaleziono
            return Response
                    .ok()
                    .entity(new Book("MockTitle", "MockAuthor", isbn))
                    .build();
        }
    }
    
    @GET
    public Response getInfo() {
        return Response
                .ok()
                .cookie(new NewCookie("auth-token", Long.toString(System.currentTimeMillis())))
                .header("test-header", "example value")
                .encoding("UTF-8")
                .build();
    }
}