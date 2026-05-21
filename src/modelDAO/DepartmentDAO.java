package modelDAO;

import modelEntities.Department;

import java.util.List;

public interface DepartmentDAO {

    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer obj);
    Department findById(Integer obj);

    List<Department> findAll();
}
