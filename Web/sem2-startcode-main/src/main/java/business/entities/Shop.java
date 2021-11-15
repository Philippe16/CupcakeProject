package business.entities;

import java.util.ArrayList;

public class Shop {

   public Shop(ArrayList<CupcakeTopping> cupcakeToppings, ArrayList<CupcakeFlavor> cupcakeFlavors){
      Shop.cupcakeToppings = cupcakeToppings;
      Shop.cupcakeFlavors = cupcakeFlavors;
   }

   private static ArrayList<CupcakeTopping> cupcakeToppings;
   private static ArrayList<CupcakeFlavor> cupcakeFlavors;

   public static ArrayList<CupcakeTopping> getCupcakeToppings() {
      return cupcakeToppings;
   }

   public static void setCupcakeToppings(ArrayList<CupcakeTopping> cupcakeToppings) {
      Shop.cupcakeToppings = cupcakeToppings;
   }

   public static ArrayList<CupcakeFlavor> getCupcakeFlavors() {
      return cupcakeFlavors;
   }

   public static void setCupcakeFlavors(ArrayList<CupcakeFlavor> cupcakeFlavors) {
      Shop.cupcakeFlavors = cupcakeFlavors;
   }

}
