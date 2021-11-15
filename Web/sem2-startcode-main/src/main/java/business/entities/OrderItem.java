package business.entities;

public class OrderItem {
   private Cupcake cupcake;
   private int amount;

   public OrderItem(Cupcake cupcake, int amount){
      this.cupcake = cupcake;
      this.amount = amount;
   }

   public Cupcake getCupcake() {
      return cupcake;
   }

   public void setCupcake(Cupcake cupcake) {
      this.cupcake = cupcake;
   }

   public int getAmount() {
      return amount;
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }

}
