package pl.javastart.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.beans.MessageBean;

/**
 * serwlet do przetestowania ziaren oznaczonych
 * @SessionScoped i @ApplicationScoped
 */
@WebServlet("/second")
public class SecondMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private MessageBean messageBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = messageBean.getMessage();
        response.getWriter().append(message);
    }
}
