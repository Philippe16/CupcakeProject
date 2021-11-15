package business.entities;

import java.util.ArrayList;

public class CupcakeShop {

   public CupcakeShop(ArrayList<CupcakeTopping> cupcakeToppings, ArrayList<CupcakeFlavor> cupcakeFlavors){
      CupcakeShop.cupcakeToppings = cupcakeToppings;
      CupcakeShop.cupcakeFlavors = cupcakeFlavors;
   }

   private static ArrayList<CupcakeTopping> cupcakeToppings;
   private static ArrayList<CupcakeFlavor> cupcakeFlavors;

   public static ArrayList<CupcakeTopping> getCupcakeToppings() {
      return cupcakeToppings;
   }

   public static CupcakeTopping getCupcakeToppingById(int id) {
      CupcakeTopping cupcakeToppingMatch = null;

      for(CupcakeTopping cupcakeTopping : cupcakeToppings){
         if(cupcakeTopping.getId() == id){
            cupcakeToppingMatch = cupcakeTopping;
            break;
         }
      }

      return cupcakeToppingMatch;
   }

   public static void setCupcakeToppings(ArrayList<CupcakeTopping> cupcakeToppings) {
      CupcakeShop.cupcakeToppings = cupcakeToppings;
   }

   public static ArrayList<CupcakeFlavor> getCupcakeFlavors() {
      return cupcakeFlavors;
   }

   public static CupcakeFlavor getCupcakeFlavorById(int id) {
      CupcakeFlavor cupcakeFlavorMatch = null;

      for(CupcakeFlavor cupcakeFlavor : cupcakeFlavors){
         if(cupcakeFlavor.getId() == id){
            cupcakeFlavorMatch = cupcakeFlavor;
            break;
         }
      }

      return cupcakeFlavorMatch;
   }

   public static void setCupcakeFlavors(ArrayList<CupcakeFlavor> cupcakeFlavors) {
      CupcakeShop.cupcakeFlavors = cupcakeFlavors;
   }

}
