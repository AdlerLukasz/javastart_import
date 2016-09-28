package pl.javastart.angular.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import pl.javastart.angular.data.ProductRepository;
import pl.javastart.angular.model.Product;

@RequestScoped
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductEndpoint {

    @Inject
    private ProductRepository repo;

    @GET
    public Response getAllProducts() {
        List<Product> products = repo.getAll();
        return Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Long id) {
        Product product = repo.get(id);
        if (product == null) {
            return Response.noContent().build();
        } else {
            return Response.ok(product).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveProduct(Product product, @Context UriInfo uriInfo) {
        repo.save(product);
        System.out.println(product);
        return Response
                .accepted(product)
                .build();
    }
}