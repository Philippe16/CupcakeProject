package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

public class UserFacade {
    UserMapper userMapper;

    public UserFacade(Database database) {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException {
        return userMapper.login(email, password);
    }

    public User createUser(String firstName, String lastName, String email, String password, double accountBalance, String role) throws UserException {
        User user = new User(firstName, lastName, email, password, accountBalance, role);
        userMapper.createUser(user);
        return user;
    }

    public void reduceUserAccountBalance(User user, Double orderPrice) throws UserException{
        userMapper.reduceUserAccountBalance(user, orderPrice);
    }

}
