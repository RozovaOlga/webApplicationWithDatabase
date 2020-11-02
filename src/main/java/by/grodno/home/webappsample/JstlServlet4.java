package by.grodno.home.webappsample;

import by.grodno.home.webappsample.service.User;
import by.grodno.home.webappsample.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class JstlServlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("number"));
        try {
            User user = UserService.getService().getUser(id);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/jstl2.jsp");
            request.setAttribute("user", user);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            User user = new User(Integer.valueOf(req.getParameter("id")),
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    Integer.valueOf(req.getParameter("department")),
                    new SimpleDateFormat("yyy-MM-dd")
                            .parse(req.getParameter("birthdate")),
                    Boolean.valueOf(req.getParameter("male")));
            user.setSalary(Double.valueOf(req.getParameter("salary")));
            UserService.getService().updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/webappsample/jstl1");
    }
}