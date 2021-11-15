package web.commands;


import business.entities.*;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

      ShoppingBag.addOrderItemToShoppingBag(orderItem);

      HttpSession session = request.getSession();

      session.setAttribute("shoppingBagItems", ShoppingBag.getOrderItems());
      session.setAttribute("shoppingBagMsg", "Delicious cupcakes were added to basket!");

      String pageToShow = "shop";
      return REDIRECT_INDICATOR + pageToShow;
   }
}
