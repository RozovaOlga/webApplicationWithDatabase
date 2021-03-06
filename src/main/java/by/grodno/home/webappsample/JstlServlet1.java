package by.grodno.home.webappsample;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.home.webappsample.service.Department;
import by.grodno.home.webappsample.service.User;
import by.grodno.home.webappsample.service.UserService;



public class JstlServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserService.getService().getUsers();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/jstl1.jsp").forward(req, resp);
    }
}

