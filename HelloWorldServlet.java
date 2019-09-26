package servlets;

import models.dao.UserDao;
import models.datas.UserData;
import models.impl.DefaultUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        UserDao test = DefaultUserDao.getUserDaoInstance();
        UserData data = test.getUserById(id);
        resp.getWriter().println(data);

        }
    }
