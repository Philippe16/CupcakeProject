package web.commands;


import business.entities.CupcakeShop;
import business.entities.CupcakeTopping;
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



      HttpSession session = request.getSession();

      session.setAttribute("addedToBasketMsg", "Delicious cupcakes were added to basket!");

      String pageToShow = "shop";
      return REDIRECT_INDICATOR + pageToShow;
   }
}
