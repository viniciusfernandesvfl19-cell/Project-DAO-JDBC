package application;

import modelDAO.DAOFactory;
import modelDAO.SellerDAO;
import modelEntities.Department;
import modelEntities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    static void main() {

        SellerDAO sellerDao = DAOFactory.createSellerDao();

        System.out.println("=== TESTING DATABASE : seller findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("=== TESTING DATABASE : seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

    }
}
