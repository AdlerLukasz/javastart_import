package pl.javastart.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

@RequestScoped
//@SessionScoped
//@ApplicationScoped
public class MessageBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String message;
    
    public MessageBean() {
        long currentTime = System.currentTimeMillis();
        message = "MessageBean " + currentTime;
    }
    
    public String getMessage() {
        return message;
    }
    
}
