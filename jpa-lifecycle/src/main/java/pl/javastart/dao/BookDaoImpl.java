package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import pl.javastart.model.Book;

public class BookDaoImpl implements BookDao {

    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emFactory;

    @Override
    public void save(Book book) {
        EntityManager em = emFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        em.close();
    }

    @Override
    public Book get(long id) {
        EntityManager em = emFactory.createEntityManager();
        Book book = em.find(Book.class, id);
        return book;
    }

    @Override
    public void remove(long bookId) {
        EntityManager em = emFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Book objToRemove = em.find(Book.class, bookId);
        tx.begin();
        em.remove(objToRemove);
        tx.commit();
    }

    @Override
    public void update(Book book) {
        EntityManager em = emFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(book);
        tx.commit();
    }

}