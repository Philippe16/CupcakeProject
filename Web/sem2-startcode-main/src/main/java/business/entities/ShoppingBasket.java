package business.entities;

import java.util.ArrayList;

public class ShoppingBasket {
   private static ArrayList<OrderItem> orderItems = new ArrayList<>();

   public static ArrayList<OrderItem> getOrderItems() {
      return orderItems;
   }

   public static void setOrderItems(ArrayList<OrderItem> orderItems) {
      ShoppingBasket.orderItems = orderItems;
   }

   public static void addOrderItemToShoppingBag(OrderItem orderItem){
      orderItems.add(orderItem);
   }
}
