package business.services;

import business.entities.Shop;
import business.exceptions.UserException;
import business.persistence.ShopMapper;
import business.persistence.Database;

public class ShopFacade {
   ShopMapper shopMapper;

   public ShopFacade(Database database) {
      shopMapper = new ShopMapper(database);
   }

   public Shop getCupcakeShopContent() throws UserException {
      return shopMapper.getCupcakeShopContent();
   }
}
