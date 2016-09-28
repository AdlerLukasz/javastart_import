package pl.javastart.chunk;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class CsvWriter extends AbstractItemWriter {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void writeItems(List<Object> items) throws Exception {
        items.stream().peek(System.out::println).forEach(em::persist);
    }
}