package application;

import modelDAO.DAOFactory;
import modelDAO.DepartmentDAO;
import modelEntities.Department;

import java.util.Scanner;

public class Program2 {

    static void main() {
        Scanner sc = new Scanner(System.in);

        DepartmentDAO departmentDao = DAOFactory.createDepartmentDao();

        System.out.println("=== DATABASE TEST 1: INSERT ===");
        Department newDepartment = new Department(null, "Foods");
        departmentDao.insert(newDepartment);
        System.out.println("Insert new Department! " + newDepartment.getName());

        sc.close();
    }
}
