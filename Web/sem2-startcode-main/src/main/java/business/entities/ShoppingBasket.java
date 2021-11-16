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

   public static void removeOrderItemById(int id){
      for(OrderItem orderItem : orderItems){
         if(orderItem.getId() == id){
            orderItems.remove(orderItem);
            break;
         }
      }
   }

   public static double getTotalPrice(){
      double totalPrice = 0.0;

      for(OrderItem orderItem : orderItems){
         totalPrice += orderItem.getCupcake().getPrice() * orderItem.getAmount();
      }

      return totalPrice;
   }

   public static int getTotalCupcakes(){
      int totalCupcakes = 0;

      for(OrderItem orderItem : orderItems){
         totalCupcakes += orderItem.getAmount();
      }

      return totalCupcakes;
   }

}
