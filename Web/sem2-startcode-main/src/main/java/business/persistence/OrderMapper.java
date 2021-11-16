package business.persistence;

import business.entities.OrderItem;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderMapper {
   private Database database;
   DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

   public OrderMapper(Database database) {
      this.database = database;
   }

   public void createOrder(User user, ArrayList<OrderItem> orderItems) throws UserException{
      try (Connection connection = database.connect()) {
         LocalDate orderDate = LocalDate.now();

         ResultSet rsFromOrders;
         int orderId;

         String sql = "INSERT INTO orders (fk_user_id, orderDate) VALUES (?, ?)";

         try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, user.getId());
            ps.setDate(2, Date.valueOf(orderDate));

            ps.executeUpdate();

            rsFromOrders = ps.getGeneratedKeys();
            rsFromOrders.next();
            orderId = rsFromOrders.getInt(1);
         } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
         }

         String sql2 = "INSERT INTO orderItems (fk_order_id, fk_cupcakeFlavor_id, fk_cupcakeTopping_id, amount, price) " +
                "VALUES (?, ?, ?, ?, ?)";

         try (PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS)) {
            for (OrderItem orderItem : orderItems) {
               ps.setInt(1, orderId);
               ps.setInt(2, orderItem.getCupcake().getCupcakeFlavor().getId());
               ps.setInt(3, orderItem.getCupcake().getCupcakeTopping().getId());
               ps.setInt(4, orderItem.getAmount());
               ps.setDouble(5, orderItem.getCupcake().getPrice());

               ps.addBatch();
            }

            ps.executeBatch();
         } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
         }
      } catch (SQLException ex) {
         throw new UserException(ex.getMessage());
      }
   }
}
