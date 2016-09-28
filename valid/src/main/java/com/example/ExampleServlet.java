package com.example;

import java.io.IOException;

import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet {
    @Inject
    private ExampleRepository repo;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MyEntity me = new MyEntity();
        me.setName("Too");
        try {
            repo.add(me);
        } catch(EJBTransactionRolledbackException e) {
            Throwable t = e.getCause();
            while ((t != null) && !(t instanceof ConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof ConstraintViolationException) {
                System.out.println("Exception caught: " + ((ConstraintViolationException)t).getMessage());
            }
        }
    }
}
