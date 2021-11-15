package business.persistence;

import business.entities.CupcakeFlavor;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CupcakeFlavorMapper {
   private Database database;

   public CupcakeFlavorMapper(Database database) {
      this.database = database;
   }

   public ArrayList<CupcakeFlavor> getAllCupcakeFlavors() throws UserException{
      try (Connection connection = database.connect()) {
         ArrayList<CupcakeFlavor> cupcakeFlavors = new ArrayList<>();

         String sql =
                "SELECT * FROM cupcakeflavors";

         try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
               while(rs.next()){
                  int id = rs.getInt("cupcakeFlavor_id");
                  String name = rs.getString("name");
                  double price = rs.getDouble("price");

                  CupcakeFlavor cupcakeFlavor = new CupcakeFlavor(name, price);
                  cupcakeFlavor.setId(id);
                  cupcakeFlavors.add(cupcakeFlavor);
               }

               return cupcakeFlavors;
            } else {
               throw new UserException("Could not get cupcake flavor data from the database");
            }
         } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }
}
