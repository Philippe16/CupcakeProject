package business.entities;

public class OrderItem {
   Cupcake cupcake;

   public OrderItem(Cupcake cupcake){
      this.cupcake = cupcake;
   }

   public Cupcake getCupcake() {
      return cupcake;
   }

   public void setCupcake(Cupcake cupcake) {
      this.cupcake = cupcake;
   }
}
