package pl.javastart.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.ejb.NamesBean;

@WebServlet("/test")
public class StatefulTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private NamesBean bean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name != null) {
            bean.addName(name);
        }
        System.out.println(bean.getId());
        bean.getNames().forEach(System.out::println);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
