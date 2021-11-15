package web.commands;

import business.entities.User;
import business.entities.User2;
import business.exceptions.UserException;
import business.services.UserFacade;
import business.services.UserFacade2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;

    public SignUpCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userFacade.createUser(firstName, lastName, email, password, 0.0, "customer");

        HttpSession session = request.getSession();

        session.setAttribute("email", email);
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());

        return "home";

    }

}
