package servlets.orderS;

import models.dao.OrderDao;
import models.impl.DefaultOrderDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao orderDao = DefaultOrderDao.getOrderDaoInstance();
        int id = Integer.parseInt(req.getParameter("idTours"));
        orderDao.deleteOrderById(id);
    }
}
