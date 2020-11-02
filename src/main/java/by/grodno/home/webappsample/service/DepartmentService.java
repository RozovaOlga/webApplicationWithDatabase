package by.grodno.home.webappsample.service;

import org.apache.log4j.Logger;

import javax.print.attribute.standard.PresentationDirection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentService {
    private static DepartmentService departmentService;

    public static final Logger LOGGER = Logger.getLogger(DepartmentService.class);

    public DepartmentService() {
    }

    public static DepartmentService getService() {
        if (departmentService == null) {
            departmentService = new DepartmentService();
        }
        return departmentService;
    }

    public List<Department> getDepartments() {
        List<Department> result = new ArrayList<Department>();
        try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL.SELECT_ALL_DEPARTMENT);
            while (rs.next()) {
                Department department = mapRawToDepartment(rs);
                result.add(department);
            }
            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }

        return result;
    }

    private Department mapRawToDepartment(ResultSet rs) throws SQLException {
        Integer id = rs.getInt(1);
        String name = rs.getString(2);
        String location = rs.getString(3);
        return new Department(id, name, location);
    }

    public void addDepartment(Department department) {
        try {
            boolean isExist = unique(department);
            if (!isExist) {
                Connection conn = DBUtils.getConnetion();
                PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_DEPARTMENT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, department.getName());
                stmt.setString(2, department.getLocation());
                stmt.executeUpdate();
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                generatedKeys.next();
                LOGGER.info("Department created with id: " + generatedKeys.getLong(1));
            } else return;
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }

    public boolean unique(Department department) throws Exception {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.UNIQUE_NAME_DEPARTMENT)) {
            stmt.setString(1, department.getName());
            ResultSet result = stmt.executeQuery();
            return result.next();
        }
    }


    public void deleteDepartment(Integer number) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_BY_ID_DEPARTMENT)) {
            stmt.setInt(1, number);
            stmt.execute();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }

    public Department getDepartment(int id) throws Exception {
        Department department = null;
        Connection conn = DBUtils.getConnetion();
        PreparedStatement stmt = conn.prepareStatement(SQL.SELECT_DEPARTMENT_BY_ID);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            department = mapRawToDepartment(rs);
        }
        rs.close();
        stmt.close();
        return department;

    }

    public void updateDepartment(Department department) throws Exception {
        boolean isExist = unique(department);
        if (!isExist) {
            Connection conn = DBUtils.getConnetion();
            PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_DEPARTMENT);
            stmt.setString(1, department.getName());
            stmt.setString(2, department.getLocation());
            stmt.setInt(3, department.getId());
            stmt.executeUpdate();
            stmt.close();
        }
    }
    public List<User> giveDepartmentUsers(Integer number){
        List<User> result = new ArrayList<User>();
        try (Connection conn = DBUtils.getConnetion(); PreparedStatement stmt = conn.prepareStatement(SQL.USERS_DEPARTMENT)) {
            stmt.setInt(1,number);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            User user=UserService.getService().mapRawToUser(rs);
                result.add(user);
            }
            System.out.println(result.toString());
            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return result;
    }
}

