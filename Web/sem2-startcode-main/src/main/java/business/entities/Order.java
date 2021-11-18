package business.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private int order_id;
    private String status;
    private LocalDate orderDate;
    private LocalDate pickupDate;
    private ArrayList<BasketItem> basketItems;

    public Order(int order_id, String status, LocalDate orderDate, LocalDate pickupDate) {
        this.order_id = order_id;
        this.status = status;
        this.orderDate = orderDate;
        this.pickupDate = pickupDate;
        this.basketItems = new ArrayList<>();
    }

    public ArrayList<BasketItem> getOrderItems() {
        return basketItems;
    }

    public void setOrderItems(ArrayList<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }
}
