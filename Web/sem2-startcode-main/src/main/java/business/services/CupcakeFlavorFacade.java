package business.services;

import business.entities.CupcakeFlavor;
import business.exceptions.UserException;
import business.persistence.CupcakeFlavorMapper;
import business.persistence.Database;

import java.util.ArrayList;

public class CupcakeFlavorFacade {
   CupcakeFlavorMapper cupcakeFlavorMapper;

   public CupcakeFlavorFacade(Database database) {
      cupcakeFlavorMapper = new CupcakeFlavorMapper(database);
   }

   public ArrayList<CupcakeFlavor> getAllCupcakeFlavors() throws UserException {
      return cupcakeFlavorMapper.getAllCupcakeFlavors();
   }
}
