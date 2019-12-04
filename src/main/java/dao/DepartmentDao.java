package dao;

import models.Department;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utility.ClassNameUtil.getClassName;
import static org.apache.logging.log4j.LogManager.getLogger;

public class DepartmentDao extends DBConnection implements BaseDao<Department> {

    public static final String FIND_ALL_QUERY = "SELECT * FROM department";
    public static final String UPDATE_ALL_QUERY = "UPDATE department SET department_name = ? WHERE id = ?";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM department WHERE id = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO department (department_name,head,worker) VALUES (?,?,?)";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM department WHERE id = ?";

    public static final Logger LOGGER = getLogger(getClassName());

    @Override
    public Department findById(Long id){
        Department department = null;
        LOGGER.trace("Started finding by id {} in database", id);
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setLong(1,id);
            ResultSet set = statement.executeQuery();
            if (set.first()){
                department = new Department();
                department.setId(id);
                department.setName(set.getString("department_name"));
            }
            LOGGER.trace("Department {} found by id successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Department {} wasn't found in database", id, e);
        }
        return department;
    }

    @Override
    public List<Department> findAll(){
        List<Department> resultList = new ArrayList<>();
        LOGGER.trace("Started finding all in database");
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERY);

            while (set.next()){
                Department department = new Department();
                department.setName(set.getString("department_name"));

                resultList.add(department);
            }
            LOGGER.trace("Department found all successfully");
        } catch (SQLException e){
            LOGGER.warn("Department wasn't found in database",e);
        }
        return resultList;
    }

    @Override
    public Long save(Department department) {
        try {
            String actionQuery = (department.getId() == null) ? INSERT_ALL_QUERY
                    : UPDATE_ALL_QUERY;
            PreparedStatement statement = connection.prepareStatement(actionQuery);


            statement.setString(1,department.getName());
            if (department.getId() != null) {
                statement.setLong(2, department.getId());
            }

            statement.execute();
            LOGGER.trace("Department {} entered all in database", department);
        }catch (SQLException e){
            LOGGER.warn("Department {} wasn't entered in database", department);
        }
        return department.getId();
    }

    @Override
    public void deleteById(Long id) {
        PreparedStatement statement;
        LOGGER.trace("Started deleting Department with id {} from database", id);
        try {
            statement = Objects.requireNonNull(connection).prepareStatement(DELETE_BY_ID_QUERY);
            statement.setLong(1,id);
            statement.execute();
            LOGGER.trace("Department with id {} deleted successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Department {} wasn't delete in database", id, e);
        }
    }
}
