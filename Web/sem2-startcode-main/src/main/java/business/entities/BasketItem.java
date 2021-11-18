package business.entities;

public class BasketItem {
   private static int idCounter = 1;

   private int id;
   private Cupcake cupcake;
   private int amount;

   public BasketItem(Cupcake cupcake, int amount){
      this.id = idCounter;
      this.cupcake = cupcake;
      this.amount = amount;

      idCounter++;
   }

   public static int getIdCounter() {
      return idCounter;
   }

   public static void setIdCounter(int idCounter) {
      BasketItem.idCounter = idCounter;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
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
