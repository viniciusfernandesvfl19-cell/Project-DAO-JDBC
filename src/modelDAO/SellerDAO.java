package modelDAO;

import modelEntities.Department;
import modelEntities.Seller;

import java.util.List;

public interface SellerDAO {

    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer obj);
    Seller findById(Integer obj);

    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}
