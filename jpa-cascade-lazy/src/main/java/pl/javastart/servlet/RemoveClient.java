package pl.javastart.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.model.Client;

@WebServlet("/removeclient")
public class RemoveClient extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emf;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long clientId = Long.parseLong(request.getParameter("clientId"));

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Client client = em.find(Client.class, clientId);
        em.remove(client);
        tx.commit();
        em.close();

        response.sendRedirect(request.getContextPath() + "/cascade.jsp");
    }
}
