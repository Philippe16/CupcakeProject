package business.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    int order_id;
    String status;
    LocalDate orderDate;
    LocalDate pickupDate;
    private static ArrayList<OrderItem> orderItems = new ArrayList<>();

    public Order(int order_id, String status, LocalDate orderDate, LocalDate pickupDate) {
        this.orderItems = orderItems;
        this.order_id = order_id;
        this.status = status;
        this.orderDate = orderDate;
        this.pickupDate = pickupDate;

    }

    public static ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public static void setOrderItems(ArrayList<OrderItem> orderItems) {
        Order.orderItems = orderItems;
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
