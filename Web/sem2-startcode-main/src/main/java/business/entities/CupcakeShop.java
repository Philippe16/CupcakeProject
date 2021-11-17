package business.entities;

import java.util.ArrayList;

public class CupcakeShop {
   private ArrayList<CupcakeTopping> cupcakeToppings;
   private ArrayList<CupcakeFlavor> cupcakeFlavors;

   public CupcakeShop(ArrayList<CupcakeTopping> cupcakeToppings, ArrayList<CupcakeFlavor> cupcakeFlavors){
      this.cupcakeToppings = cupcakeToppings;
      this.cupcakeFlavors = cupcakeFlavors;
   }

   public ArrayList<CupcakeTopping> getCupcakeToppings() {
      return cupcakeToppings;
   }

   public CupcakeTopping getCupcakeToppingById(int id) {
      CupcakeTopping cupcakeToppingMatch = null;

      for(CupcakeTopping cupcakeTopping : cupcakeToppings){
         if(cupcakeTopping.getId() == id){
            cupcakeToppingMatch = cupcakeTopping;
            break;
         }
      }

      return cupcakeToppingMatch;
   }

   public void setCupcakeToppings(ArrayList<CupcakeTopping> cupcakeToppings) {
      this.cupcakeToppings = cupcakeToppings;
   }

   public ArrayList<CupcakeFlavor> getCupcakeFlavors() {
      return cupcakeFlavors;
   }

   public CupcakeFlavor getCupcakeFlavorById(int id) {
      CupcakeFlavor cupcakeFlavorMatch = null;

      for(CupcakeFlavor cupcakeFlavor : cupcakeFlavors){
         if(cupcakeFlavor.getId() == id){
            cupcakeFlavorMatch = cupcakeFlavor;
            break;
         }
      }

      return cupcakeFlavorMatch;
   }

   public void setCupcakeFlavors(ArrayList<CupcakeFlavor> cupcakeFlavors) {
      this.cupcakeFlavors = cupcakeFlavors;
   }

}
