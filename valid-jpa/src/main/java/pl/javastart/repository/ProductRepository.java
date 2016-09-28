package pl.javastart.repository;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import pl.javastart.model.Product;

@Stateless
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;
    
    public void add(Product product) {
        try {
            em.persist(product);
        } catch(ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            for (ConstraintViolation<?> v : violations) {
                System.out.printf("%s - %s (%s)\n", 
                        v.getPropertyPath(),
                        v.getInvalidValue(),
                        v.getMessage());
            }
        }
    }
}