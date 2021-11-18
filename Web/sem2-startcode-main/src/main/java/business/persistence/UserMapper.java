package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;

public class UserMapper {
    private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

    public void createUser(User user) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO users (firstName, lastName, email, password, accountBalance) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getFirstName());
                ps.setString(2, user.getLastName());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                ps.setDouble(5, user.getAccountBalance());

                ps.executeUpdate();

                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException {
        try (Connection connection = database.connect()) {
            String sql =
                   "SELECT users.user_id, users.firstName, users.lastName, users.accountBalance, userroles.role\n" +
                   "FROM (users\n" +
                   "INNER JOIN userroles ON users.fk_userRole_id = userroles.userRole_id) " +
                   "WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("user_id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    double accountBalance = rs.getDouble("accountBalance");
                    String role = rs.getString("role");

                    User user = new User(firstName, lastName, email, password, accountBalance, role);
                    user.setId(id);

                    return user;
                } else {
                    throw new UserException("Could not validate user");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public void reduceUserAccountBalance(User user, Double orderPrice) throws UserException{
        try (Connection connection = database.connect()) {
            String sql =
                   "UPDATE users SET accountBalance = (accountBalance - ?) WHERE user_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setDouble(1, orderPrice);
                ps.setInt(2, user.getId());

                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

}
