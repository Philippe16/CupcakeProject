package business.persistence;

import business.entities.OrderItem;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderItemMapper {
   private Database database;

   public OrderItemMapper(Database database) {
      this.database = database;
   }

   public ArrayList<OrderItem> getAllOrderItemsByOrderId(int orderId) throws UserException{
      try (Connection connection = database.connect()) {
         String sql =
                "SELECT orders.order_id, cupcakeflavors.name AS cupcakeFlavor, cupcaketoppings.name AS cupcakeTopping, orderitems.amount, orderitems.price\n" +
                       "FROM (((orderitems\n" +
                       "INNER JOIN orders on orderitems.fk_order_id = orders.order_id)\n" +
                       "INNER JOIN cupcakeflavors on orderitems.fk_cupcakeFlavor_id = cupcakeflavors.cupcakeFlavor_id)\n" +
                       "INNER JOIN cupcaketoppings on orderitems.fk_cupcakeTopping_id = cupcaketoppings.cupcakeTopping_id)\n" +
                       "WHERE order_id = ?";

         try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            ArrayList<OrderItem> orderItems = new ArrayList<>();

            if (rs.next()) {
               do {
                  int order_id = rs.getInt("order_id");
                  String cupcakeFlavor = rs.getString("cupcakeFlavor");
                  String cupcakeTopping = rs.getString("cupcakeTopping");
                  int amount = rs.getInt("amount");
                  double price = rs.getDouble("price");

                  OrderItem orderItem = new OrderItem(order_id, cupcakeFlavor, cupcakeTopping, amount, price);
                  orderItems.add(orderItem);
               } while (rs.next());

               return orderItems;
            } else {
               throw new UserException("Could get retrieve order details from our database at the moment");
            }
         } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

}
