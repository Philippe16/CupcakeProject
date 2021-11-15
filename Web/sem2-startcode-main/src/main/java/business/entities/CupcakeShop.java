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

   public static void setCupcakeToppings(ArrayList<CupcakeTopping> cupcakeToppings) {
      CupcakeShop.cupcakeToppings = cupcakeToppings;
   }

   public static ArrayList<CupcakeFlavor> getCupcakeFlavors() {
      return cupcakeFlavors;
   }

   public static void setCupcakeFlavors(ArrayList<CupcakeFlavor> cupcakeFlavors) {
      CupcakeShop.cupcakeFlavors = cupcakeFlavors;
   }

}
