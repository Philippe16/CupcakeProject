package business.services;

import business.entities.OrderItem;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderItemMapper;

import java.util.ArrayList;

public class OrderItemFacade {
   OrderItemMapper orderItemMapper;

   public OrderItemFacade(Database database) {
      this.orderItemMapper = new OrderItemMapper(database);
   }

   public ArrayList<OrderItem> getAllOrderItemsByOrderId(int orderId) throws UserException {
      return orderItemMapper.getAllOrderItemsByOrderId(orderId);
   }
}
