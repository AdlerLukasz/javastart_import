package pl.javastart.batch;

import java.util.List;
import java.util.Random;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class NameWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager em;
    
    @Inject
    JobContext jobCtx;
    
    public NameWriter() {
        System.out.println("Creating writer");
    }
    
    @Override
    public void writeItems(List<Object> items) throws Exception {
        System.out.println("Persisting " + items);
        if(new Random().nextDouble() > 0.5) {
            System.err.println("Exception");
            throw new Exception("Random Exception");
        }
        items.forEach(em::persist);
    }

}