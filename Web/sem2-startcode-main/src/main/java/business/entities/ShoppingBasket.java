package business.entities;

import java.util.ArrayList;

public class ShoppingBasket {

   private static ArrayList<BasketItem> basketItems = new ArrayList<>();

   public static ArrayList<BasketItem> getOrderItems() {
      return basketItems;
   }

   public static void setOrderItems(ArrayList<BasketItem> basketItems) {
      ShoppingBasket.basketItems = basketItems;
   }

   public static void addOrderItemToShoppingBag(BasketItem basketItem){
      basketItems.add(basketItem);
   }

   public static void removeOrderItemById(int id){
      for(BasketItem basketItem : basketItems){
         if(basketItem.getId() == id){
            basketItems.remove(basketItem);
            break;
         }
      }
   }

   public static double getTotalPrice(){
      double totalPrice = 0.0;

      for(BasketItem basketItem : basketItems){
         totalPrice += basketItem.getCupcake().getPrice() * basketItem.getAmount();
      }

      return totalPrice;
   }

   public static int getTotalCupcakes(){
      int totalCupcakes = 0;

      for(BasketItem basketItem : basketItems){
         totalCupcakes += basketItem.getAmount();
      }

      return totalCupcakes;
   }

}
