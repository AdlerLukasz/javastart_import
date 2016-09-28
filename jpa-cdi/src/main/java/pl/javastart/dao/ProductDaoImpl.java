package pl.javastart.dao;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pl.javastart.model.Product;
import pl.javastart.util.TransactionalMethod;

@RequestScoped
public class ProductDaoImpl implements ProductDao {
    
    @Inject
    private EntityManager em;

    @Override
    @TransactionalMethod
    public void save(Product product) {
        em.persist(product);
    }
    
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> findAllQuery = em.createNamedQuery("Product.findAll", Product.class);
        List<Product> resultList = findAllQuery.getResultList();
        return resultList;
    }

    @Override
    public List<Product> customQuery(String customQuery, Map<String, Object> params) {
        TypedQuery<Product> query = em.createQuery(customQuery, Product.class);
        insertParameters(query, params);
        List<Product> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Product> namedQuery(String namedQuery, Map<String, Object> params) {
        TypedQuery<Product> query = em.createNamedQuery(namedQuery, Product.class);
        insertParameters(query, params);
        List<Product> resultList = query.getResultList();
        return resultList;
    }
    
    private void insertParameters(Query query, Map<String, Object> params) {
        if(params != null)
            for(String paramName: params.keySet()) {
                Object param = params.get(paramName);
                query.setParameter(paramName, param);
            }
    }
}