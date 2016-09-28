package pl.javastart.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
//@Stateless
public class TodoServiceImpl implements TodoServiceRemote {
    
    private List<String> taskList;
    
    @PostConstruct
    private void init() {
        taskList = new ArrayList<>();
    }

    @Override
    public void addTask(String task) {
        taskList.add(task);
    }

    @Override
    public List<String> getTaskList() {
        return taskList;
    }
    
    @Override
    @Remove
    public void closeSession() {
    }
}