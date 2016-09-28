package pl.javastart.security;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secret")
@ServletSecurity(
        @HttpConstraint(rolesAllowed={"admin"})
)
public class SecuredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Principal principal = request.getUserPrincipal();
	    String name = principal.getName();
	    
	    response.getWriter().println("This is secured area, welcome " + name);
	}

}
