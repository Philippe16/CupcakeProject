package web.commands;

import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignInCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;

    public SignInCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userFacade.login(email, password);
            System.out.println(user.getEmail());

            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("email", email);

            String pageToShow = "home";
            return REDIRECT_INDICATOR + pageToShow;
        } catch (UserException ex) {
            request.setAttribute("error", "Wrong username or password!");
            ex.printStackTrace();

            return "signIn";
        }
    }

}
