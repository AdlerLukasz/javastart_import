package pl.javastart.jaxrs.endpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.javastart.jaxrs.model.Book;

@RequestScoped
@Path("/books")
public class BookEndpoint {

    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public void saveBook(Book book) {
        System.out.println("Saving book");
        System.out.printf("%s %s %s\n", book.getTitle(), book.getAuthor(), book.getIsbn());
        // zapisanie ksi��ki w bazie
    }

    @GET
    @Path("/{isbn}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Book get(@PathParam("isbn") String isbn) {
        return new Book("MockTitle", "SomeAuthor", isbn);
    }
}