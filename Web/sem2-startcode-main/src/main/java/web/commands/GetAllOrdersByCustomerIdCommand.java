package web.commands;

import business.entities.Order;
import business.entities.OrderItem;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.OrderItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetAllOrdersByCustomerIdCommand extends CommandUnprotectedPage {
    OrderFacade orderFacade;
    OrderItemFacade orderItemFacade;

    public GetAllOrdersByCustomerIdCommand(String pageToShow) {
        super(pageToShow);
        orderFacade = new OrderFacade(database);
        orderItemFacade = new OrderItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        try {
            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("user");

            ArrayList<Order> orders = orderFacade.getAllOrdersByCustomerId(user.getId());

            for(Order order : orders){
                ArrayList<OrderItem> orderItems = orderItemFacade.getAllOrderItemsByOrderId(order.getOrder_id());
                order.setOrderItems(orderItems);

                double totalOrderPrice = 0.0;

                for(OrderItem orderItem : orderItems){
                    totalOrderPrice += orderItem.getPrice() * orderItem.getAmount();
                }

                order.setTotalOrderPrice(totalOrderPrice);
            }

            session.setAttribute("customerOrders", orders);

            return REDIRECT_INDICATOR + "orders";
        }catch (UserException ex){
            request.setAttribute("error", "Something went wrong when getting orders from the database");
            return "orders";
        }

    }
}
