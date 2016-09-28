package pl.javastart.jaxrs.endpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/headers")
public class HeaderEndpoint {

    @Context
    private HttpHeaders headers;

    @GET
    @Path("/useragent2")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getUserAgent() {
        return Response.ok(headers.getHeaderString("user-agent")).build();
    }

    @GET
    @Path("/useragent")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getUserAgent(@HeaderParam("user-agent") String userAgent) {
        return Response.ok(userAgent).build();
    }

}
