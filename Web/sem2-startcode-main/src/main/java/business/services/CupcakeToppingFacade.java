package business.services;

import business.entities.CupcakeTopping;
import business.exceptions.UserException;
import business.persistence.CupcakeToppingMapper;
import business.persistence.Database;

import java.util.ArrayList;

public class CupcakeToppingFacade {
   CupcakeToppingMapper cupcakeToppingMapper;

   public CupcakeToppingFacade(Database database) {
      cupcakeToppingMapper = new CupcakeToppingMapper(database);
   }

   public ArrayList<CupcakeTopping> getAllCupcakeToppings() throws UserException {
      return cupcakeToppingMapper.getAllCupcakeToppings();
   }
}
