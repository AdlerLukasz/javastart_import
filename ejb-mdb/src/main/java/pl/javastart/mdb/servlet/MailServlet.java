package pl.javastart.mdb.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.mdb.dto.MessageWrapper;
import pl.javastart.mdb.producer.MailService;

@WebServlet("/mail")
public class MailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private MailService mailService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String recipient = request.getParameter("recipient");
        String message = request.getParameter("message");
        MessageWrapper msg = new MessageWrapper(recipient, message);
        mailService.sendMessage(msg);
    }
}