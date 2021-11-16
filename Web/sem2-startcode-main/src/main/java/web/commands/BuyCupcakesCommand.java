package web.commands;

import business.entities.OrderItem;
import business.entities.ShoppingBasket;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class BuyCupcakesCommand extends CommandUnprotectedPage {
   OrderFacade orderFacade;

   public BuyCupcakesCommand(String pageToShow) {
      super(pageToShow);
      orderFacade = new OrderFacade(database);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
      try {
         if(ShoppingBasket.getOrderItems().size() == 0){
            throw new UserException("Your basket is still empty!");
         }

         if(request.getAttribute("user") == null){
            throw new UserException("You need to be signed in to buy cupcakes");
         }

         User user = (User) request.getAttribute("user");

         if(user.getAccountBalance() < Double.parseDouble(request.getParameter("shoppingBasketTotalPrice"))){
            throw new UserException("Your account balance is too low...");
         }

         /* Send order items to the database */
         orderFacade.createOrder(user, ShoppingBasket.getOrderItems());

         HttpSession session = request.getSession();

         /* Empty the ShoppingBasket's orderItems list + Update session attributes */
         ShoppingBasket.getOrderItems().clear();
         session.setAttribute("shoppingBasketItems", ShoppingBasket.getOrderItems());
         session.setAttribute("shoppingBasketTotalPrice", ShoppingBasket.getTotalPrice());
         session.setAttribute("shoppingBasketTotalCupcakes", ShoppingBasket.getTotalCupcakes());

         return REDIRECT_INDICATOR + "shoppingBasket";
      } catch (UserException ex) {
         request.setAttribute("error", ex.getMessage());
         return "shoppingBasket";
      }
   }

}
