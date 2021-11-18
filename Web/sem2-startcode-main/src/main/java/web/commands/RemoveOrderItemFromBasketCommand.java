package web.commands;

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

      /* Update the variables stored in the sessionScope */
      session.setAttribute("shoppingBasketItems", ShoppingBasket.getOrderItems());
      session.setAttribute("shoppingBasketTotalPrice", ShoppingBasket.getTotalPrice());
      session.setAttribute("shoppingBasketTotalCupcakes", ShoppingBasket.getTotalCupcakes());;

      String pageToShow = "shoppingBasket";

      return REDIRECT_INDICATOR + pageToShow;
   }
}
