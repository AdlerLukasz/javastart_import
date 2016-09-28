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

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ProductDao dao;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean add = Boolean.parseBoolean(request.getParameter("add"));
        if(add) {
            addProduct(request);
            response.sendRedirect(request.getContextPath());
        } else {
            getProducts(request);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
    
    private void addProduct(HttpServletRequest request) {
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productCategory = request.getParameter("productCategory");
        Product product = new Product(productName, productPrice, productCategory);
        dao.save(product);
    }

    private void getProducts(HttpServletRequest request) {
        String userQuery = request.getParameter("query");
        List<Product> resultList = dao.customQuery(userQuery, null);
        request.setAttribute("query", userQuery);
        request.setAttribute("products", resultList);
    }
}