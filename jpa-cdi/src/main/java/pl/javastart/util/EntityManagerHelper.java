package pl.javastart.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerHelper {
    
    @PersistenceContext
    EntityManager em;
    
    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return em;
    }
    
}
