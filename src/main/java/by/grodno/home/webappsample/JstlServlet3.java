package by.grodno.home.webappsample;

import by.grodno.home.webappsample.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JstlServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");

        UserService.getService().deleteUser(Integer.valueOf(parameter));

        resp.sendRedirect("/webappsample/jstl1");

    }

}