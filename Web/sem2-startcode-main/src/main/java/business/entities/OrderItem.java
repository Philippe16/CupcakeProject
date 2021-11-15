package business.entities;

public class OrderItem {
   Cupcake cupcake;

   public Cupcake getCupcake() {
      return cupcake;
   }

   public void setCupcake(Cupcake cupcake) {
      this.cupcake = cupcake;
   }

   OrderItem(Cupcake cupcake){
      this.cupcake = cupcake;
   }
}
