package modelDAO.impl;

import db.DB;
import db.DbException;
import modelDAO.DepartmentDAO;
import modelEntities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDAO {

    private Connection connection;

    public DepartmentDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connection.prepareStatement("INSERT INTO department "
                    + "(Name) "
                    + "VALUES "
                    + "(?) ", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());

            int affected = st.executeUpdate();

            if (affected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    obj.setId(rs.getInt(1));
                }
            }
            else {
                throw new DbException("Failed to insert department");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer obj) {

    }

    @Override
    public Department findById(Integer obj) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
