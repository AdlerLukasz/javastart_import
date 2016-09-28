package pl.javastart.batch;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

import pl.javastart.model.User;

@Named
public class NameProcessor implements ItemProcessor {

    public NameProcessor() {
        System.out.println("Creating processor");
    }
    
    @Override
    public Object processItem(Object item) throws Exception {
        System.out.println("Processing: " + item);
        String textLine = (String)item;
        String[] userData = textLine.split(",");
        return new User(userData[0], userData[1]);
    }

}
