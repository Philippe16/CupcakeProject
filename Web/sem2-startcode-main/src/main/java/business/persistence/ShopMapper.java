package business.persistence;

import business.entities.CupcakeFlavor;
import business.entities.CupcakeShop;
import business.entities.CupcakeTopping;
import business.exceptions.UserException;

import java.util.ArrayList;

public class ShopMapper {
   private Database database;
   private CupcakeToppingMapper cupcakeToppingMapper;
   private CupcakeFlavorMapper cupcakeFlavorMapper;

   public ShopMapper(Database database) {
      this.database = database;
      cupcakeToppingMapper = new CupcakeToppingMapper(database);
      cupcakeFlavorMapper = new CupcakeFlavorMapper(database);
   }

   public CupcakeShop getCupcakeShopContent() throws UserException {
      ArrayList<CupcakeTopping> cupcakeToppings = cupcakeToppingMapper.getAllCupcakeToppings();
      ArrayList<CupcakeFlavor> cupcakeFlavors = cupcakeFlavorMapper.getAllCupcakeFlavors();

      return new CupcakeShop(cupcakeToppings, cupcakeFlavors);
   }
}
