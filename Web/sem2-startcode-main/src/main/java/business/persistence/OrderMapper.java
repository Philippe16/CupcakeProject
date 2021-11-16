package business.persistence;

import business.entities.OrderItem;

import java.util.ArrayList;

public class OrderMapper {
   private Database database;

   public OrderMapper(Database database) {
      this.database = database;
   }

   public void createOrder(ArrayList<OrderItem> orderItems){

   }
}
