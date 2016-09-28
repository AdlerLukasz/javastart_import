import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pl.javastart.ejb.TodoServiceRemote;

public class Main {
    public static void main(String[] args) throws NamingException {
        Properties contextProperties = new Properties();
        contextProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        contextProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        contextProperties.put("jboss.naming.client.ejb.context", true);
        Context context = new InitialContext(contextProperties);
        
        TodoServiceRemote todoBean = (TodoServiceRemote) context
                .lookup("ejb-stateful-server/TodoServiceImpl!pl.javastart.ejb.TodoServiceRemote");
        todoBean.addTask("Pierwsze");
        todoBean.addTask("Drugie");
        todoBean.addTask("Trzecie");

        List<String> taskList = todoBean.getTaskList();
        System.out.println(taskList);
        todoBean.closeSession();
    }
}
