package business.persistence;

import business.entities.Order;
import business.entities.BasketItem;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderMapper {
   private Database database;

   public OrderMapper(Database database) {
      this.database = database;
   }

   public void createOrder(User user, ArrayList<BasketItem> basketItems) throws UserException{
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
            for (BasketItem basketItem : basketItems) {
               ps.setInt(1, orderId);
               ps.setInt(2, basketItem.getCupcake().getCupcakeFlavor().getId());
               ps.setInt(3, basketItem.getCupcake().getCupcakeTopping().getId());
               ps.setInt(4, basketItem.getAmount());
               ps.setDouble(5, basketItem.getCupcake().getPrice());

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

   public ArrayList<Order> getAllOrdersByCustomerId(int userId) throws UserException{
      try (Connection connection = database.connect()) {
         String sql =
                 "SELECT orders.order_id, orderstatuses.status, orders.orderDate, orders.pickupDate \n" +
                         "FROM (orders\n" +
                         "INNER JOIN orderstatuses ON orders.fk_orderStatus_id = orderstatuses.orderStatus_id) \n" +
                         "WHERE fk_user_id = ? \n" +
                         "ORDER BY orders.pickupDate";


         try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
               ArrayList<Order> orders = new ArrayList<>();

               while (rs.next()) {
                  int order_id = rs.getInt("order_id");
                  String status = rs.getString("status");
                  LocalDate orderDate = rs.getDate("orderDate").toLocalDate();
                  LocalDate pickupDate = rs.getDate("pickupDate").toLocalDate();

                  Order order = new Order(order_id, status, orderDate, pickupDate);
                  orders.add(order);
               }

               return orders;
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



}
