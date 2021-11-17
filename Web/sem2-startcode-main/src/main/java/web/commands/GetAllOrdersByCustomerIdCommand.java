package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.ShopFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetAllOrdersByCustomerIdCommand extends CommandUnprotectedPage {
    OrderFacade orderFacade;
    public GetAllOrdersByCustomerIdCommand(String pageToShow) {
        super(pageToShow);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            ArrayList<Order> orders = orderFacade.getAllOrdersByCustomerId(user.getId());

            session.setAttribute("customerOrders", orders);

            return REDIRECT_INDICATOR + "orders";
        }catch (UserException ex){
            request.setAttribute("error", "Couldn't get customer orders from database currently");
            return "orders";
        }

    }
}
