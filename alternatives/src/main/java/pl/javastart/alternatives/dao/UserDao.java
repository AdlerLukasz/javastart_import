package pl.javastart.alternatives.dao;

import pl.javastart.alternatives.model.User;

public interface UserDao {
    public User read(long id);
}
