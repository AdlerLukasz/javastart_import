package pl.javastart.alternatives.main;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import pl.javastart.alternatives.service.UserService;

public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        
        UserService userService = container.select(UserService.class).get();
        userService.printUser(25L);
        
        container.shutdown();
    }
}
