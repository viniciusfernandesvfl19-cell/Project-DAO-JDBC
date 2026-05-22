package modelDAO;

import db.DB;
import modelDAO.impl.DepartmentDaoJDBC;
import modelDAO.impl.SellerDaoJDBC;

public class DAOFactory {

    public static SellerDAO createSellerDao() {

        return new SellerDaoJDBC(DB.getConnection());
    }
    public static DepartmentDAO createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
