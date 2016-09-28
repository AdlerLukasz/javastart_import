package pl.javastart.alternatives.dao;

import javax.enterprise.inject.Alternative;

import pl.javastart.alternatives.model.User;

@Alternative
public class UserDaoMock implements UserDao {

    @Override
    public User read(long id) {
        // zwracamy obiekt bez odwo³ywania siê do bazy
        // tylko na potrzeby testów / wersji deweloperskiej
        return new User(id, "MockFirst", "MockLast");
    }
}
