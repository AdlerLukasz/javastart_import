package pl.javastart.batch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Objects;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class NameReader extends AbstractItemReader {

    private BufferedReader reader;
    
    @PersistenceContext
    EntityManager em;
    
    public NameReader() {
        System.out.println("Creating Reader");
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        reader = new BufferedReader(
                    new InputStreamReader(
                            Thread
                            .currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream("people.csv")
                            )
                    );
        //consume header
        reader.readLine();
    }

    @Override
    public Object readItem() throws Exception {
        String line = reader.readLine();
        System.out.println("Reading: " + line);
        return Objects.nonNull(line)? line : null;
    }

}
