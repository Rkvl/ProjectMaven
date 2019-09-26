package servlets.userS;

import models.dao.UserDao;
import models.impl.DefaultUserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteUserByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = DefaultUserDao.getUserDaoInstance();
        int id = Integer.parseInt(req.getParameter("idUser"));
        userDao.deleteUserById(id);
    }
}