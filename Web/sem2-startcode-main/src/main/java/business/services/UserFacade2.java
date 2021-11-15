package business.services;

import business.entities.User;
import business.entities.User2;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;
import business.persistence.UserMapper2;

public class UserFacade2 {
   UserMapper2 userMapper2;

   public UserFacade2(Database database) {
      userMapper2 = new UserMapper2(database);
   }

   public User2 login(String email, String password) throws UserException {
      return userMapper2.login(email, password);
   }

   public User2 createUser(String email, String password) throws UserException {
      User2 user = new User2(email, password, "customer");
      userMapper2.createUser(user);
      return user;
   }

}
