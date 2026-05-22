package application;

import modelDAO.DAOFactory;
import modelDAO.SellerDAO;
import modelEntities.Department;
import modelEntities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    static void main() {

        Scanner sc = new Scanner(System.in);

        SellerDAO sellerDao = DAOFactory.createSellerDao();

        System.out.println("=== TESTING DATABASE : seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();

        System.out.println("=== TESTING DATABASE : seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("=== TESTING DATABASE : seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("=== TESTING DATABASE : seller insert ===");
        Seller newSeller = new Seller(
                null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Seller ID: " + newSeller.getId());

        System.out.println();

        System.out.println("=== TESTING DATABASE : seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Updated! New Seller");

        System.out.println();

        System.out.println("=== TESTING DATABASE : seller delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted Complete!");

        sc.close();

    }
}
