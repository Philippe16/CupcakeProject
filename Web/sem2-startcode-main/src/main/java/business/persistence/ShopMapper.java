package business.persistence;

import business.entities.CupcakeFlavor;
import business.entities.Shop;
import business.entities.CupcakeTopping;
import business.exceptions.UserException;

import java.util.ArrayList;

public class ShopMapper {
   private Database database;
   private CupcakeToppingMapper cupcakeToppingMapper;
   private CupcakeFlavorMapper cupcakeFlavorMapper;

   public ShopMapper(Database database) {
      this.database = database;
   }

   public Shop getCupcakeShopContent() throws UserException {
      ArrayList<CupcakeTopping> cupcakeToppings = cupcakeToppingMapper.getAllCupcakeToppings();
      ArrayList<CupcakeFlavor> cupcakeFlavors = cupcakeFlavorMapper.getAllCupcakeFlavors();

      Shop cupcakeShop = new Shop(cupcakeToppings, cupcakeFlavors);

      return cupcakeShop;
   }
}
