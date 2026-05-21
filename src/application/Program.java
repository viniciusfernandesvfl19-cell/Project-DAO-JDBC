package application;

import modelDAO.DAOFactory;
import modelDAO.SellerDAO;
import modelEntities.Department;
import modelEntities.Seller;

import java.util.Date;

public class Program {

    static void main() {

        SellerDAO sellerDao = DAOFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}
