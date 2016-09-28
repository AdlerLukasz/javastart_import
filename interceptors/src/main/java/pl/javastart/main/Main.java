package pl.javastart.main;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import pl.javastart.beans.User;
import pl.javastart.dao.UserDao;

public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        UserDao userDao = container.select(UserDao.class).get();
        User user = userDao.read(25L);
        System.out.println(user);

        container.shutdown();
    }
}
