package web.commands;


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
      String cupcakeTopping = request.getParameter("email");
      String cupcakeFlavor = request.getParameter("password");
      int amount = Integer.parseInt(request.getParameter("amount"));
      double pricePrCupcake;

      HttpSession session = request.getSession();
      
      session.setAttribute("addedToBasketMsg", "Delicious cupcakes were added to basket!");

      String pageToShow = "shop";
      return REDIRECT_INDICATOR + pageToShow;
   }
}
