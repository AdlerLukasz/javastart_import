package pl.javastart.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.dao.ProductDao;
import pl.javastart.model.Product;

@WebServlet("/static")
public class ProductServletStatic extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private ProductDao dao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> resultList = dao.namedQuery("Product.findAllOrderByPrice", null);
        request.setAttribute("products", resultList);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}