package pl.javastart.jaxrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/people")
@RequestScoped
public class PersonEndpoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> getAll(@QueryParam("orderBy") @DefaultValue("asc") String order,
            @QueryParam("page") @DefaultValue("1") int page) {
        List<String> people = new ArrayList<>(Arrays.asList(new String[] { "Person 1", "Person 2", "Person 3" }));

        if ("asc".equals(order)) {
            people.sort((a, b) -> a.compareTo(b));
        } else if ("desc".equals(order)) {
            people.sort((a, b) -> b.compareTo(a));
        }
        return people;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPerson(@PathParam("id") long id) {
        return "Person " + id;
    }

    @GET
    @Path("/{id}/phones/{phoneId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPersonPhone(@PathParam("id") long id, @PathParam("phoneId") int phoneId) {
        return "Person " + id + " phone " + phoneId;
    }
}