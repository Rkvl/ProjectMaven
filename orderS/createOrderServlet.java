package servlets.orderS;

import models.dao.OrderDao;
import models.datas.OrdersData;
import models.impl.DefaultOrderDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class createOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao orderDao = DefaultOrderDao.getOrderDaoInstance();

        int userId = Integer.parseInt(req.getParameter("userId"));
        int countryId = Integer.parseInt(req.getParameter("countryId"));
        int tourId = Integer.parseInt(req.getParameter("tourId"));

        orderDao.createOrder(userId,countryId,tourId);

    }
}
