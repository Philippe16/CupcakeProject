package business.entities;

public class Cupcake {
   private CupcakeTopping cupcakeTopping;
   private CupcakeFlavor cupcakeFlavor;
   private double price;

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

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}
