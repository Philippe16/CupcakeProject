package web.commands;

import business.entities.ShoppingBasket;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyCupcakesCommand extends CommandUnprotectedPage {
   OrderFacade orderFacade;
   UserFacade userFacade;

   public BuyCupcakesCommand(String pageToShow) {
      super(pageToShow);
      orderFacade = new OrderFacade(database);
      userFacade = new UserFacade(database);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
      try {
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute("user");
         Double orderPrice = (Double) session.getAttribute("shoppingBasketTotalPrice");

         /* Test if purchase is doable */
         checkIfBasketIsEmpty();
         checkIfUserIsSignedIn(user);
         checkIfUserBalanceIsEnough(user, orderPrice);

         /* Send order to the database */
         orderFacade.createOrder(user, ShoppingBasket.getOrderItems());

         /* Update user account balance */
         userFacade.reduceUserAccountBalance(user, orderPrice);
         user.setAccountBalance(user.getAccountBalance() - orderPrice);

         /* Empty the ShoppingBasket's orderItems list */
         ShoppingBasket.getOrderItems().clear();

         /* Update session attributes */
         session.setAttribute("user", user);
         session.setAttribute("shoppingBasketItems", ShoppingBasket.getOrderItems());
         session.setAttribute("shoppingBasketTotalPrice", ShoppingBasket.getTotalPrice());
         session.setAttribute("shoppingBasketTotalCupcakes", ShoppingBasket.getTotalCupcakes());
         session.setAttribute("orderConfirmed", true);

         String pageToShow = "shoppingBasket";

         return REDIRECT_INDICATOR + pageToShow;
      } catch (UserException ex) {
         request.setAttribute("error", ex.getMessage());
         return "shoppingBasket";
      }
   }

   private void checkIfBasketIsEmpty() throws UserException{
      if(ShoppingBasket.getOrderItems().size() == 0){
         throw new UserException("Your basket is still empty!");
      }
   }

   private void checkIfUserIsSignedIn(User user) throws UserException{
      if(user == null){
         throw new UserException("You need to be signed in to buy cupcakes");
      }
   }

   private void checkIfUserBalanceIsEnough(User user, Double orderPrice) throws UserException{
      if(user.getAccountBalance() < orderPrice){
         throw new UserException("Your account balance is too low...");
      }
   }

}
