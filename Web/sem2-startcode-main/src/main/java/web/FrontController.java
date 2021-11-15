package web;

import business.entities.CupcakeFlavor;
import business.entities.Shop;
import business.entities.CupcakeTopping;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.CupcakeFlavorFacade;
import business.services.CupcakeToppingFacade;
import web.commands.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/fc/*"})
public class FrontController extends HttpServlet
{
    private final static String USER = "root";
    private final static String PASSWORD = "kisshu25"; // Change to your own local MySQL password
    private final static String URL = "jdbc:mysql://localhost:3306/dreamycupcakesdb?serverTimezone=CET";

    public static Database database;
    public static Shop cupcakeShop;

    public void init() throws ServletException {
        // Initialize database connection
        if (database == null) {
            try {
                database = new Database(USER, PASSWORD, URL);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger("web").log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

        // Initialize whatever global datastructures needed here:
        if(FrontController.cupcakeShop == null){
            try{
                CupcakeToppingFacade cupcakeToppingFacade = new CupcakeToppingFacade(database);
                ArrayList<CupcakeTopping> cupcakeToppings = cupcakeToppingFacade.getAllCupcakeToppings();

                CupcakeFlavorFacade cupcakeFlavorFacade = new CupcakeFlavorFacade(database);
                ArrayList<CupcakeFlavor> cupcakeFlavors = cupcakeFlavorFacade.getAllCupcakeFlavors();

                cupcakeShop = new Shop(cupcakeToppings, cupcakeFlavors);

            }catch(UserException ex){
                Logger.getLogger("web").log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Command action = Command.fromPath(request, database);

            if (action instanceof CommandUnknown) {
                response.sendError(404);
                return;
            }

            String view = action.execute(request, response);

            if (view.startsWith(Command.REDIRECT_INDICATOR)) {
                String page = view.substring(Command.REDIRECT_INDICATOR.length());
                response.sendRedirect(page);
                return;
            }

            request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);
        } catch (UnsupportedEncodingException | UserException ex) {
            request.setAttribute("problem", ex.getMessage());
            Logger.getLogger("web").log(Level.SEVERE, ex.getMessage(), ex);
            request.getRequestDispatcher("/errorpage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "FrontController for application";
    }

}