package pl.javastart.jaxrs.endpoint;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/example")
@RequestScoped
public class ContextEndpoint {

    @Context
    private HttpServletRequest request;
    
    @GET
    public void requestInfo(@Context HttpServletResponse response) throws IOException {
        String param = request.getParameter("param");
        System.out.println(param);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath);
    }
    
    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response save(@FormParam("email") String email,
                         @Context UriInfo uriInfo) {
        System.out.println(uriInfo.getAbsolutePath());
        System.out.println(uriInfo.getBaseUri());
        System.out.println(uriInfo.getPath());
        List<PathSegment> pathSegments = uriInfo.getPathSegments();
        pathSegments.forEach(x -> System.out.println(x.getPath()));
        return Response
                .created(uriInfo
                        .getAbsolutePathBuilder()
                        .path(email).build())
                .build();
    }
}