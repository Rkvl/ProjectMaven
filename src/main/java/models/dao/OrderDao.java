package models.dao;

import models.datas.OrdersData;

import java.util.List;

public interface OrderDao {

    List<OrdersData> getAllOrders();

    OrdersData getOrderById(int id);

    boolean deleteOrderById(int id);

    boolean updateOrder(OrdersData ordersData);

    OrdersData getOrderByUserId(int id);


}
