package pl.javastart.dao;

import java.util.List;
import java.util.Map;

import pl.javastart.model.Product;

public interface ProductDao {
    
    public void save(Product product);
    
    public List<Product> findAll();
    
    public List<Product> customQuery(String customQuery, Map<String, Object> params);
    
    public List<Product> namedQuery(String customQuery, Map<String, Object> params);
}
