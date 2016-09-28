package pl.javastart.jaxrs.endpoint;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/cookies")
public class CookieEndpoint {

    @Context
    private HttpHeaders headers;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCookies(@CookieParam("auth-token") Cookie cookie) {
        Map<String, Cookie> cookies = headers.getCookies();
        return Response.ok(cookies).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCookie(@CookieParam("auth-token") Cookie cookie) {
        if (cookie != null)
            return Response.ok(cookie).build();
        else
            return Response.status(404).build();
    }

}
