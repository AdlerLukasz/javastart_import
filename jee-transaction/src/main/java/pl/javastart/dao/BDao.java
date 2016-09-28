package pl.javastart.dao;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import pl.javastart.model.BeanB;

@Stateless
public class BDao {

    @PersistenceContext
    private EntityManager em;
    
    @Resource
    private TransactionSynchronizationRegistry tsr;

    @Transactional(TxType.REQUIRES_NEW)
    public void saveB() {
        BeanB b = new BeanB("second");
        em.persist(b);
        try {
            em.flush();
        } catch (PersistenceException e) {
            System.out.println("PERSISTENCE EXCEPTION");
        }
        System.out.println("TRS STATUS: " + tsr.getTransactionStatus() + " " + tsr.getRollbackOnly());
    }
}