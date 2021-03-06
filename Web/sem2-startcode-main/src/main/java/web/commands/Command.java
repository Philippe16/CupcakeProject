package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database) {
        commands = new HashMap<>();
        /* Website pages commands */
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("home", new CommandUnprotectedPage("home"));
        commands.put("about", new CommandUnprotectedPage("about"));
        commands.put("shop", new CommandUnprotectedPage("shop"));
        commands.put("contact", new CommandUnprotectedPage("contact"));
        commands.put("signIn", new CommandUnprotectedPage("signIn"));
        commands.put("signUp", new CommandUnprotectedPage("signUp"));
        commands.put("account", new CommandProtectedPage("account", "customer"));
        commands.put("shoppingBasket", new CommandUnprotectedPage("shoppingBasket"));
        commands.put("orders", new CommandProtectedPage("orders", "customer"));

        /* Functionality commands */
        commands.put("signUpCommand", new SignUpCommand(""));
        commands.put("signInCommand", new SignInCommand(""));
        commands.put("signOutCommand", new LogoutCommand(""));
        commands.put("getShopContentCommand", new GetShopContentCommand(""));
        commands.put("addToBasketCommand", new AddToBasketCommand(""));
        commands.put("removeOrderItemFromBasketCommand", new RemoveOrderItemFromBasketCommand(""));
        commands.put("buyCupcakesCommand", new BuyCupcakesCommand(""));
        commands.put("getAllOrdersByCustomerIdCommand", new GetAllOrdersByCustomerIdCommand(""));


        /* To be deleted later */
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommandz(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null) {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;

}
