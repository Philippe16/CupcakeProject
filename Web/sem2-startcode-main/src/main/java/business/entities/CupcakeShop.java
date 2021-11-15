package business.entities;

import java.util.ArrayList;

public class CupcakeShop {

   public CupcakeShop(ArrayList<CupcakeTopping> cupcakeToppings, ArrayList<CupcakeFlavor> cupcakeFlavors){
      this.cupcakeToppings = cupcakeToppings;
      this.cupcakeFlavors = cupcakeFlavors;
   }

   private ArrayList<CupcakeTopping> cupcakeToppings;
   private ArrayList<CupcakeFlavor> cupcakeFlavors;

   public ArrayList<CupcakeTopping> getCupcakeToppings() {
      return cupcakeToppings;
   }

   public void setCupcakeToppings(ArrayList<CupcakeTopping> cupcakeToppings) {
      this.cupcakeToppings = cupcakeToppings;
   }

   public ArrayList<CupcakeFlavor> getCupcakeFlavors() {
      return cupcakeFlavors;
   }

   public void setCupcakeFlavors(ArrayList<CupcakeFlavor> cupcakeFlavors) {
      this.cupcakeFlavors = cupcakeFlavors;
   }

}
