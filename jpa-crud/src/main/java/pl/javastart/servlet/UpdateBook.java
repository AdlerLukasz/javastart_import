package pl.javastart.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.dao.BookDao;
import pl.javastart.model.Book;

@WebServlet("/update")
public class UpdateBook extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private BookDao bookDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String isbn = request.getParameter("isbn");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        Book book = new Book(isbn, name, author);
        book.setId(id);
        bookDao.update(book);
        response.sendRedirect(request.getContextPath());
    }
}
