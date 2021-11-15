package business.entities;

public class Cupcake {
   CupcakeTopping cupcakeTopping;
   CupcakeFlavor cupcakeFlavor;
   double price;

   public Cupcake(CupcakeTopping cupcakeTopping, CupcakeFlavor cupcakeFlavor){
      this.cupcakeTopping = cupcakeTopping;
      this.cupcakeFlavor = cupcakeFlavor;
      this.price = cupcakeTopping.getPrice() + cupcakeFlavor.getPrice();
   }

   public CupcakeTopping getCupcakeTopping() {
      return cupcakeTopping;
   }

   public void setCupcakeTopping(CupcakeTopping cupcakeTopping) {
      this.cupcakeTopping = cupcakeTopping;
   }

   public CupcakeFlavor getCupcakeFlavor() {
      return cupcakeFlavor;
   }

   public void setCupcakeFlavor(CupcakeFlavor cupcakeFlavor) {
      this.cupcakeFlavor = cupcakeFlavor;
   }
}
