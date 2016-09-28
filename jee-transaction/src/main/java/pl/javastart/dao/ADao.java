package pl.javastart.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import pl.javastart.model.BeanA;

@RequestScoped
public class ADao {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private BDao daoB;

    @Transactional(TxType.REQUIRED)
    public void saveA() {
        BeanA a = new BeanA("first");
        em.persist(a);
        try {
            daoB.saveB();
        } catch(Exception e) {
            System.out.println("catch: " + e.getClass());
        }
    }
}