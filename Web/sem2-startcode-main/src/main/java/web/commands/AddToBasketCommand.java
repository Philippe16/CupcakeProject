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

      HttpSession session = request.getSession();

      CupcakeShop cupcakeShop = (CupcakeShop) session.getAttribute("cupcakeShop");

      CupcakeTopping cupcakeTopping = cupcakeShop.getCupcakeToppingById(cupcakeToppingId);
      CupcakeFlavor cupcakeFlavor = cupcakeShop.getCupcakeFlavorById(cupcakeFlavorId);

      BasketItem basketItem = new BasketItem(new Cupcake(cupcakeTopping, cupcakeFlavor), amount);

      ShoppingBasket.addOrderItemToShoppingBag(basketItem);

      session.setAttribute("shoppingBasketItems", ShoppingBasket.getOrderItems());
      session.setAttribute("shoppingBasketTotalPrice", ShoppingBasket.getTotalPrice());
      session.setAttribute("shoppingBasketTotalCupcakes", ShoppingBasket.getTotalCupcakes());
      session.setAttribute("shoppingBasketItemCount", ShoppingBasket.getOrderItems().size());
      session.setAttribute("shoppingBagMsg", "Delicious cupcakes were added to basket!");

      String pageToShow = "shop";
      return REDIRECT_INDICATOR + pageToShow;
   }

}
