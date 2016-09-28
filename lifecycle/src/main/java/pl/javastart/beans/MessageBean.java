package pl.javastart.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class MessageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    public MessageBean() {
        long currentTime = System.currentTimeMillis();
        message = "MessageBean " + currentTime;
        System.out.println("Constructor call");
    }

    public String getMessage() {
        return message;
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("PostConstruct()");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("PreDestroy()");
    }
}
