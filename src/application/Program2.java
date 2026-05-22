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

        System.out.println();

        System.out.println("=== DATABASE TEST 2: UPDATE ===");
        Department dep = departmentDao.findById(3);
        dep.setName("Gamers");
        departmentDao.update(dep);
        System.out.println("Updated Department! " + dep.getName());

        sc.close();
    }
}
