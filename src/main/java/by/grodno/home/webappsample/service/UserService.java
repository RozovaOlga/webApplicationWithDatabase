package by.grodno.home.webappsample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


public class UserService {

    private static UserService userService;

    public static final Logger LOGGER = Logger.getLogger(UserService.class);

    public UserService() {
    }

    public static UserService getService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getUsers() {
        List<User> result = new ArrayList<User>();
        try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL.SELECT_ALL);
            while (rs.next()) {
                User user = mapRawToUser(rs);
                result.add(user);
                if (user.getDepartment() != null && user.getDepartment().toString().length() > 0) {
                    user.setDepartments(rr(rs));
                }
            }
            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return result;
    }

    public List<Department> rr(ResultSet rs) throws SQLException {
        List <Department>   departmentList= new ArrayList<Department>();
        Department department = new Department();
        department.setId(rs.getInt(8));
        department.setName(rs.getString(9));
        department.setLocation(rs.getString(10));
        departmentList.add(department);
        return departmentList;
    }

    public User mapRawToUser(ResultSet rs) throws SQLException {
        Integer id = rs.getInt(1);
        String fName = rs.getString(2);
        String lName = rs.getString(3);
        Double sal = rs.getDouble(4);
        Date date = rs.getTimestamp(5);
        Boolean male = rs.getBoolean(6);
        Integer dept = rs.getInt(7) == 0 ? null : rs.getInt(7);
        User user = new User(id, fName, lName, dept, date, male, sal);
        return user;
    }

    public void deleteUser(Integer number) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_BY_ID)) {
            stmt.setInt(1, number);
            stmt.execute();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }

    public void addUser(User user) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.INSERT, Statement.RETURN_GENERATED_KEYS)) {
            setUserDB(stmt, user);
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            generatedKeys.next();
            LOGGER.info("User created with id: " + generatedKeys.getLong(1));

        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }

    public void updateUser(User user) throws Exception {
        Connection conn = DBUtils.getConnetion();
        PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE);
        setUserDB(stmt, user);
        stmt.setInt(7, user.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public User getUser(int id) throws Exception {
        User user = null;
        Connection conn = DBUtils.getConnetion();
        PreparedStatement stmt = conn.prepareStatement(SQL.SELECT_USER_BY_ID);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            user = mapRawToUser(rs);
        }
        rs.close();
        stmt.close();
        return user;
    }

    private void setUserDB(PreparedStatement stmt, User user) {
        try {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setDouble(4, user.getSalary());
            stmt.setTimestamp(5,
                    Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(user.getBirthdate())));
            stmt.setBoolean(6, user.isMale());
            stmt.setInt(3, user.getDepartment());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}