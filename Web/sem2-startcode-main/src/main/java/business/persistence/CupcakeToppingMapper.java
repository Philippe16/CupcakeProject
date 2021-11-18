package business.persistence;

import business.entities.CupcakeTopping;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CupcakeToppingMapper {
   private Database database;

   public CupcakeToppingMapper(Database database) {
      this.database = database;
   }

   public ArrayList<CupcakeTopping> getAllCupcakeToppings() throws UserException{
      try (Connection connection = database.connect()) {
         ArrayList<CupcakeTopping> cupcakeToppings = new ArrayList<>();

         String sql =
                "SELECT * FROM cupcaketoppings";

         try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
               do {
                  int id = rs.getInt("cupcakeTopping_id");
                  String name = rs.getString("name");
                  double price = rs.getDouble("price");

                  CupcakeTopping cupcakeTopping = new CupcakeTopping(name, price);
                  cupcakeTopping.setId(id);
                  cupcakeToppings.add(cupcakeTopping);
               } while (rs.next());

               return cupcakeToppings;
            } else {
               throw new UserException("Could not get cupcake topping data from the database");
            }
         } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }
}
