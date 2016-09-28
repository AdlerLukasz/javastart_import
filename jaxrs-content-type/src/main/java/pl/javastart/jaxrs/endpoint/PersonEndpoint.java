package pl.javastart.jaxrs.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.javastart.jaxrs.model.Person;

@Path("/people")
public class PersonEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jan", "Kowalski", "123456789", 23));
        people.add(new Person("Kasia", "Abacka", "987654321", 33));
        people.add(new Person("Wojciech", "Zumba", "132435465", 13));
        return people;
    }
    
    @GET
    @Path("/{pesel}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByPesel(@PathParam("pesel") String pesel) {
        return new Person(null, "Kowalski", pesel, 23);
    }
}
