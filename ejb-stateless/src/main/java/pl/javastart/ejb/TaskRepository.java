package pl.javastart.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.javastart.model.TodoTask;

@Stateless
public class TaskRepository {

    @PersistenceContext
    private EntityManager em;
    
    public void add(TodoTask task) {
        em.persist(task);
    }
    
    public void remove(TodoTask task) {
        em.remove(task);
    }
    
    public List<TodoTask> getAll() {
        TypedQuery<TodoTask> query = em.createNamedQuery("TodoTask.findAll", TodoTask.class);
        List<TodoTask> resultList = query.getResultList();
        return resultList;
    }
}