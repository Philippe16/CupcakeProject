package business.services;

import business.entities.OrderItem;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.ArrayList;

public class OrderFacade {
   OrderMapper orderMapper;

   public OrderFacade(Database database){
      orderMapper = new OrderMapper(database);
   }

   public void createOrder (ArrayList<OrderItem> orderItems){
      orderMapper.createOrder(orderItems);
   }

}
