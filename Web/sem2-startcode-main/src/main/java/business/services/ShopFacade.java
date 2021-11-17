package business.services;

import business.entities.CupcakeShop;
import business.exceptions.UserException;
import business.persistence.CupcakeShopMapper;
import business.persistence.Database;

public class ShopFacade {
   CupcakeShopMapper cupcakeShopMapper;

   public ShopFacade(Database database) {
      cupcakeShopMapper = new CupcakeShopMapper(database);
   }

   public CupcakeShop getCupcakeShopContent() throws UserException {
      return cupcakeShopMapper.getCupcakeShopContent();
   }
}
