package pl.javastart.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class NamesBean {

    private List<String> names;
    private long id;
    
    @PostConstruct
    private void init() {
        names = new ArrayList<>();
        id = System.currentTimeMillis();
    }
    
    public void addName(String name) {
        names.add(name);
    }
    
    public List<String> getNames() {
        return names;
    }
    
    public long getId() {
        return id;
    }
    
}
