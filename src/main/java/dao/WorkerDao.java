package dao;

import models.Worker;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utility.ClassNameUtil.getClassName;
import static org.apache.logging.log4j.LogManager.getLogger;

public class WorkerDao extends DBConnection implements BaseDao<Worker> {

    public static final String FIND_ALL_QUERY = "SELECT * FROM worker";
    public static final String UPDATE_ALL_QUERY = "UPDATE worker SET name = ?, education= ?, dateOfBirth = ?, dateOfHiring = ?, phoneNumber = ?, passportNumber = ? WHERE id = ?";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM worker WHERE id = ?";
    public static final String INSERT_ALL_QUERY = "INSERT INTO worker (name,education,dateOfBirth,dateOfHiring,phoneNumber,passportNumber) VALUES (?,?,?,?,?,?)";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM worker WHERE id = ?";

    public static final Logger LOGGER = getLogger(getClassName());

    @Override
    public Worker findById(Long id){
        Worker worker = null;
        LOGGER.trace("Started finding by id {} in database", id);
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setLong(1,id);
            ResultSet set = statement.executeQuery();
            if (set.first()){
                worker = new Worker();
                worker.setId(id);
                worker.setEducation(set.getString("education"));
                worker.setName(set.getString("name"));
                worker.setDateOfBirth(LocalDate.parse(set.getDate("dateOfBirth").toString()));
                worker.setDateOfHiring(LocalDate.parse(set.getDate("dateOfHiring").toString()));
                worker.setPhoneNumber(set.getInt("phoneNumber"));
                worker.setPassportNumber(set.getInt("passportNumber"));
            }
            LOGGER.trace("Worker {} found by id successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Worker {} wasn't found in database", id, e);
        }
        return worker;
    }

    @Override
    public List<Worker> findAll(){
        List<Worker> resultList = new ArrayList<>();
        LOGGER.trace("Started finding all in database");
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(FIND_ALL_QUERY);

            while (set.next()){
                Worker worker = new Worker();
                worker.setEducation(set.getString("education"));
                worker.setName(set.getString("name"));
                worker.setDateOfBirth(LocalDate.parse(set.getDate("dateOfBirth").toString()));
                worker.setDateOfHiring(LocalDate.parse(set.getDate("dateOfHiring").toString()));
                worker.setPhoneNumber(set.getInt("phoneNumber"));
                worker.setPassportNumber(set.getInt("passportNumber"));

                resultList.add(worker);
            }
            LOGGER.trace("Worker found all successfully");
        } catch (SQLException e){
            LOGGER.warn("Worker wasn't found in database",e);
        }
        return resultList;
    }

    @Override
    public Long save(Worker worker) {
        try {
            String actionQuery = (worker.getId() == null) ? INSERT_ALL_QUERY
                    : UPDATE_ALL_QUERY;
            PreparedStatement statement = connection.prepareStatement(actionQuery);


            statement.setString(1,worker.getEducation());
            statement.setString(2,worker.getName());
            statement.setLong(3,worker.getPassportNumber());
            statement.setLong(4,worker.getPhoneNumber());
            statement.setTimestamp(5, Timestamp.valueOf(worker.getDateOfBirth().atStartOfDay()));
            statement.setTimestamp(6,Timestamp.valueOf(worker.getDateOfHiring().atStartOfDay()));

            if (worker.getId() != null) {
                statement.setLong(7, worker.getId());
            }

            statement.execute();
            LOGGER.trace("Worker {} entered all in database", worker);
        }catch (SQLException e){
            LOGGER.warn("Worker {} wasn't entered in database", worker);
        }
        return worker.getId();
    }

    @Override
    public void deleteById(Long id) {
        PreparedStatement statement;
        LOGGER.trace("Started deleting Worker with id {} from database", id);
        try {
            statement = Objects.requireNonNull(connection).prepareStatement(DELETE_BY_ID_QUERY);
            statement.setLong(1,id);
            statement.execute();
            LOGGER.trace("Worker with id {} deleted successfully", id);
        }catch (SQLException e){
            LOGGER.warn("Worker {} wasn't delete in database", id, e);
        }
    }
}
