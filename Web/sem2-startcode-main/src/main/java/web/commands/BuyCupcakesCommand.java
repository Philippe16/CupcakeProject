package web.commands;

import business.entities.CupcakeShop;
import business.entities.OrderItem;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyCupcakesCommand extends CommandUnprotectedPage {

   public BuyCupcakesCommand(String pageToShow) {
      super(pageToShow);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

      return REDIRECT_INDICATOR + "shoppingBasket";
   }

}
