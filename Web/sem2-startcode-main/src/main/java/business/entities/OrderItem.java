package business.entities;

public class OrderItem {
   private int order_id;
   private String cupcakeFlavor;
   private String cupcakeTopping;
   private int amount;
   private double price;

   public OrderItem(int order_id, String cupcakeFlavor, String cupcakeTopping, int amount, double price) {
      this.order_id = order_id;
      this.cupcakeFlavor = cupcakeFlavor;
      this.cupcakeTopping = cupcakeTopping;
      this.amount = amount;
      this.price = price;
   }

   public int getOrder_id() {
      return order_id;
   }

   public void setOrder_id(int order_id) {
      this.order_id = order_id;
   }

   public String getCupcakeFlavor() {
      return cupcakeFlavor;
   }

   public void setCupcakeFlavor(String cupcakeFlavor) {
      this.cupcakeFlavor = cupcakeFlavor;
   }

   public String getCupcakeTopping() {
      return cupcakeTopping;
   }

   public void setCupcakeTopping(String cupcakeTopping) {
      this.cupcakeTopping = cupcakeTopping;
   }

   public int getAmount() {
      return amount;
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

}
