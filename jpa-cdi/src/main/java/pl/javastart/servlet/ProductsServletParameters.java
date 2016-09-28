package pl.javastart.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.dao.ProductDao;
import pl.javastart.model.Product;

@WebServlet("/category")
public class ProductsServletParameters extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private ProductDao dao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");
        HashMap<String, Object> params = new HashMap<>();
        params.put("category", category);
        
        List<Product> resultList = dao.namedQuery("Product.findByCategory", params);
        request.setAttribute("products", resultList);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}