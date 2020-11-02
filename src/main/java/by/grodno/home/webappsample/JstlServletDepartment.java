package by.grodno.home.webappsample;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.home.webappsample.service.Department;
import by.grodno.home.webappsample.service.DepartmentService;
import by.grodno.home.webappsample.service.User;
import by.grodno.home.webappsample.service.UserService;


@WebServlet(urlPatterns = {"/jstlDepartment", "/jstlDepartment/delete", "/jstlDepartment/new", "/jstlDepartment/edit", "/jstlDepartment/update",
        "/jstlDepartment/departmentUsers"})
public class JstlServletDepartment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/jstlDepartment/new":
                    addNewDepartment(req, resp);
                    break;
                case "/jstlDepartment/delete":
                    deleteDepartment(req, resp);
                    break;
                case "/jstlDepartment/edit":
                    editDepartment(req, resp);
                    break;
                case "/jstlDepartment/update":
                    updateDepartment(req, resp);
                    break;
                case "/jstlDepartment/departmentUsers":
                    departmentUsers(req, resp);
                    break;
                default:
                    listDepartment(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void listDepartment(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        List<Department> departments = DepartmentService.getService().getDepartments();
        req.setAttribute("departments", departments);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jstlDepartment.jsp");
        dispatcher.forward(req, resp);
    }


    private void deleteDepartment(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        String parameter = req.getParameter("id");
        DepartmentService.getService().deleteDepartment(Integer.valueOf(parameter));
        resp.sendRedirect("/webappsample/jstlDepartment");

    }

    private void addNewDepartment(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Department department = createObjectDepartment(req, resp);
        DepartmentService.getService().addDepartment(department);
        resp.sendRedirect("/webappsample/jstlDepartment");
    }

    public void editDepartment(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Department department = DepartmentService.getService().getDepartment(id);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jstlAddDepartment.jsp");
            req.setAttribute("department", department);
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDepartment(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Department department = createObjectDepartment(req, resp);
        try {
            DepartmentService.getService().updateDepartment(department);
            resp.sendRedirect("/webappsample/jstlDepartment");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Department createObjectDepartment(HttpServletRequest req, HttpServletResponse resp) {
        Department department = new Department(req.getParameter("id") == null ? null : Integer.valueOf(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("location"));
        return department;
    }

    public void departmentUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String parameter = req.getParameter("id");
        List<User> departmentUsers = DepartmentService.getService().giveDepartmentUsers(Integer.valueOf(parameter));
        req.setAttribute("departmentUsers", departmentUsers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jstlAddUserOnDepartment.jsp");
        dispatcher.forward(req, resp);
    }
}