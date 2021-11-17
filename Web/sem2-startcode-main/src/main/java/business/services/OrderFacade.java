package business.services;

import business.entities.Order;
import business.entities.OrderItem;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.ArrayList;

public class OrderFacade {
   OrderMapper orderMapper;

   public OrderFacade(Database database){
      orderMapper = new OrderMapper(database);
   }

   public void createOrder (User user, ArrayList<OrderItem> orderItems) throws UserException {
      orderMapper.createOrder(user, orderItems);
   }

   public ArrayList<Order> getAllOrdersByCustomerId(int userId) throws UserException {
      return orderMapper.getAllOrdersByCustomerId(userId);

   }

}
