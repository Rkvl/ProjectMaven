package servlets.userS;

import models.dao.UserDao;
import models.impl.DefaultUserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class userCreateServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username = req.getParameter("name");
            String lastName = req.getParameter("lastname");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            int role = Integer.parseInt(req.getParameter("role"));


        UserDao userDao = DefaultUserDao.getUserDaoInstance();
        userDao.createUser(username,lastName,password,email,role);
    }
}
