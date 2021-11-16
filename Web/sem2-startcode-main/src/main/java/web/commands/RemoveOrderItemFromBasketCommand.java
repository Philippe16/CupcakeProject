package web.commands;

import business.entities.OrderItem;
import business.entities.ShoppingBasket;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoveOrderItemFromBasketCommand extends CommandUnprotectedPage {

   public RemoveOrderItemFromBasketCommand(String pageToShow) {
      super(pageToShow);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
      int orderItemToBeRemovedId = Integer.parseInt(request.getParameter("orderItemToBeRemoved"));

      ShoppingBasket.removeOrderItemById(orderItemToBeRemovedId);

      HttpSession session = request.getSession();

      session.setAttribute("shoppingBasketItems", ShoppingBasket.getOrderItems());
      session.setAttribute("shoppingBasketTotalPrice", ShoppingBasket.getTotalPrice());
      session.setAttribute("shoppingBasketTotalCupcakes", ShoppingBasket.getTotalCupcakes());;

      return REDIRECT_INDICATOR + "shoppingBasket";
   }
}
