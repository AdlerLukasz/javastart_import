package pl.javastart.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface TodoServiceRemote {
    public void addTask(String task);
    public List<String> getTaskList();
    public void closeSession();
}
