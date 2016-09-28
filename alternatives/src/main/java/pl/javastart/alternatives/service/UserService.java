package pl.javastart.alternatives.service;

import javax.inject.Inject;

import pl.javastart.alternatives.dao.UserDao;
import pl.javastart.alternatives.model.User;

public class UserService {

    @Inject
    private UserDao userDao;
    
    public void printUser(long id) {
        User user = userDao.read(id);
        System.out.println(user);
    }
}
