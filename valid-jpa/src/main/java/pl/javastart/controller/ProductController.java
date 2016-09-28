package pl.javastart.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.model.Product;
import pl.javastart.repository.ProductRepository;

@WebServlet("/products")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private ProductRepository products;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String quantity = request.getParameter("quantity");
        Product product = new Product(name, description, Integer.parseInt(quantity));
        products.add(product);
        response.sendRedirect(request.getContextPath());
    }
}