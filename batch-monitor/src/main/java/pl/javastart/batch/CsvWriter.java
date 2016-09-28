package pl.javastart.batch;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class CsvWriter extends AbstractItemWriter {

    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private StepContext stepCtx;
    
    @Override
    public void writeItems(List<Object> items) throws Exception {
        items.stream().peek(System.out::println).forEach(em::persist);
        stepCtx.setExitStatus("WRITE_COMPLETE");
    }
}