package pl.javastart.angular.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.javastart.angular.model.Product;

@Stateless
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Product> getAll() {
        TypedQuery<Product> getAllQuery = em.createNamedQuery("Product.findAll", Product.class);
        List<Product> products = getAllQuery.getResultList();
        return products;
    }

    public Product get(Long id) {
        TypedQuery<Product> byIdQuery = em.createNamedQuery("Product.findById", Product.class);
        byIdQuery.setParameter("id", id);
        List<Product> resultList = byIdQuery.getResultList();
        if (resultList.isEmpty())
            return null;
        else
            return resultList.get(0);
    }
    
    public void save(Product product) {
        em.persist(product);
    }
}