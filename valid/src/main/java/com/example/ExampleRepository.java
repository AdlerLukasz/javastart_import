package com.example;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.validation.ConstraintViolationException;

@RequestScoped
public class ExampleRepository {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(value=TxType.REQUIRED)
    public void add(MyEntity me) {
        try {
            em.persist(me);
            em.flush();
        } catch (Exception e) {
            System.out.println(">>> " + e.getMessage());
        }
            
    }
}
