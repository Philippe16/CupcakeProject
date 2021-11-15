package business.services;

import business.entities.CupcakeShop;
import business.exceptions.UserException;
import business.persistence.ShopMapper;
import business.persistence.Database;

public class ShopFacade {
   ShopMapper shopMapper;

   public ShopFacade(Database database) {
      shopMapper = new ShopMapper(database);
   }

   public CupcakeShop getCupcakeShopContent() throws UserException {
      return shopMapper.getCupcakeShopContent();
   }
}
