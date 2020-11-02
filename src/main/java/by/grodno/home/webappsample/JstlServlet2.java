package by.grodno.home.webappsample;

import by.grodno.home.webappsample.service.User;
import by.grodno.home.webappsample.service.UserService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JstlServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = new User(null,
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    Integer.valueOf(req.getParameter("department")),
                    new SimpleDateFormat("yyy-MM-dd")
                            .parse(req.getParameter("birthdate")),
                    Boolean.valueOf(req.getParameter("male")));
            user.setSalary(Double.valueOf(req.getParameter("salary")));
            UserService.getService().addUser(user);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/webappsample/jstl1");
    }
}
