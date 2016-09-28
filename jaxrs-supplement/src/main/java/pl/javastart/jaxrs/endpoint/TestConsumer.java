package pl.javastart.jaxrs.endpoint;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.javastart.jaxrs.model.Book;

@Path("/consumer")
public class TestConsumer {

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response consume(List<Book> books) {
        System.out.println(books);
        return Response.ok(new GenericEntity<List<Book>>(books, List.class){}).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response produce() {
        List<Book> books = Arrays
                .asList(new Book[] { 
                        new Book("aaa", "AAA", "12345"), 
                        new Book("bbb", "BBB", "09876") 
                        });
        Response.ok(new GenericEntity<List<Book>>(books, List.class) {});
        return Response.ok(new Book("123", "456", "123456789")).build();
    }

}
