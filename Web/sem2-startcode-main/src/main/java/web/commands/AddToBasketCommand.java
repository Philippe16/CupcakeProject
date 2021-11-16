package web.commands;


import business.entities.*;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AddToBasketCommand extends CommandUnprotectedPage{
   public AddToBasketCommand(String pageToShow) {
      super(pageToShow);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
      int cupcakeToppingId = Integer.parseInt(request.getParameter("cupcakeTopping"));
      int cupcakeFlavorId = Integer.parseInt(request.getParameter("cupcakeFlavor"));
      int amount = Integer.parseInt(request.getParameter("amountOfCupcakes"));

      CupcakeTopping cupcakeTopping = CupcakeShop.getCupcakeToppingById(cupcakeToppingId);
      CupcakeFlavor cupcakeFlavor = CupcakeShop.getCupcakeFlavorById(cupcakeFlavorId);

      OrderItem orderItem = new OrderItem(new Cupcake(cupcakeTopping, cupcakeFlavor), amount);

      ShoppingBasket.addOrderItemToShoppingBag(orderItem);
      double shoppingBasketTotalPrice = getTotalPrice(ShoppingBasket.getOrderItems());
      int shoppingBasketTotalCupcakes = getTotalCupcakes(ShoppingBasket.getOrderItems());

      HttpSession session = request.getSession();

      session.setAttribute("shoppingBasketItems", ShoppingBasket.getOrderItems());
      session.setAttribute("shoppingBasketTotalPrice", shoppingBasketTotalPrice);
      session.setAttribute("shoppingBasketTotalCupcakes", shoppingBasketTotalCupcakes);
      session.setAttribute("shoppingBagMsg", "Delicious cupcakes were added to basket!");

      String pageToShow = "shop";
      return REDIRECT_INDICATOR + pageToShow;
   }

   private double getTotalPrice(ArrayList<OrderItem> orderItems){
      double totalPrice = 0.0;

      for(OrderItem orderItem : orderItems){
         totalPrice += orderItem.getCupcake().getPrice() * orderItem.getAmount();
      }

      return totalPrice;
   }

   private int getTotalCupcakes(ArrayList<OrderItem> orderItems){
      int totalCupcakes = 0;

      for(OrderItem orderItem : orderItems){
         totalCupcakes += orderItem.getAmount();
      }

      return totalCupcakes;
   }
}
