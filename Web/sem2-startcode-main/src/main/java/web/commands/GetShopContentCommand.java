package web.commands;

import business.entities.CupcakeShop;
import business.exceptions.UserException;
import business.services.ShopFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetShopContentCommand extends CommandUnprotectedPage {
   private ShopFacade shopFacade;

   public GetShopContentCommand(String pageToShow) {
      super(pageToShow);
      shopFacade = new ShopFacade(database);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
      try {
         CupcakeShop cupcakeShop = shopFacade.getCupcakeShopContent();

         HttpSession session = request.getSession();

         session.setAttribute("cupcakeShop", cupcakeShop);
         session.setAttribute("cupcakeToppings", cupcakeShop.getCupcakeToppings());
         session.setAttribute("cupcakeFlavors", cupcakeShop.getCupcakeFlavors());

         String pageToShow = "shop";
         return REDIRECT_INDICATOR + pageToShow;
      } catch (UserException ex) {
         request.setAttribute("error", "Could not retrieve shop content...");
         ex.printStackTrace();
         return "error";
      }
   }
}
