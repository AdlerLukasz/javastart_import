package pl.javastart.alternatives.dao;

import pl.javastart.alternatives.model.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User read(long id) {
        // Connection...
        // PreparedStatement ...
        // User user ...
        // pobieramy dane z bazy i zwracamy istniej¹cy w bazie rekord
        return new User(id, "RealFirstName", "RealLastName");
    }

}
