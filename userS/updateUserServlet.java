package servlets.userS;

import models.dao.UserDao;
import models.datas.UserData;
import models.impl.DefaultUserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class updateUserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = DefaultUserDao.getUserDaoInstance();
        UserData userData = new UserData();

        userData.setIdUser(Integer.parseInt(req.getParameter("idUser")));
        userData.setStatus(Integer.parseInt(req.getParameter("status")));
        userData.setName(req.getParameter("name"));
        userData.setLastName(req.getParameter("lastName"));
        userData.setEmail(req.getParameter("email"));
        userData.setPassword(req.getParameter("password"));

        userDao.updateUser(userData);
    }
}