package servlets.orderS;

import models.dao.OrderDao;
import models.datas.OrdersData;
import models.impl.DefaultOrderDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao orderDao = DefaultOrderDao.getOrderDaoInstance();
        OrdersData ordersData = new OrdersData();

        ordersData.setOrderId(Integer.parseInt(req.getParameter("orderId")));
        ordersData.setUserId(Integer.parseInt(req.getParameter("userId")));
        ordersData.setTourId(Integer.parseInt(req.getParameter("tourId")));
        ordersData.setCountryId(Integer.parseInt(req.getParameter("countryId")));

        orderDao.updateOrder(ordersData);

    }
}
