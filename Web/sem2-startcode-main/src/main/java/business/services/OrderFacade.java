package business.services;

import business.entities.Order;
import business.entities.BasketItem;
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

   public void createOrder (User user, ArrayList<BasketItem> basketItems) throws UserException {
      orderMapper.createOrder(user, basketItems);
   }

   public ArrayList<Order> getAllOrdersByCustomerId(int userId) throws UserException {
      return orderMapper.getAllOrdersByCustomerId(userId);

   }

}
