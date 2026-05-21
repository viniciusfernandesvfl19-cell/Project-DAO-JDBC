package modelDAO;

import db.DB;
import modelDAO.impl.SellerDaoJDBC;

public class DAOFactory {

    public static SellerDAO createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
