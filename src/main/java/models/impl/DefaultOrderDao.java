package models.impl;

import connection.DataBaseConnection;
import models.dao.OrderDao;
import models.datas.OrdersData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultOrderDao implements OrderDao {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();

    private static final String GET_ALL_ORDERS = "SELECT * FROM orders ";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM orders WHERE id_order = ?";
    private static final String DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE id_order = ? ";
    private static final String UPDATE_ORDER = "UPDATE orders SET id_user = ?, id_tour = ?, id_country = ? WHERE id_order = ? ";
    private static final String GET_ORDER_BY_USER_ID = "SELECT * FROM orders WHERE id_user = ?";


    @Override
    public List<OrdersData> getAllOrders() {
        List<OrdersData> ordersDataList = new ArrayList<>();
        OrdersData ordersData = null;

        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDERS)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ordersData = new OrdersData();
                ordersData.setOrderId(rs.getInt("id_order"));
                ordersData.setUserId(rs.getInt("id_user"));
                ordersData.setTourId(rs.getInt("id_tour"));
                ordersData.setCountryId(rs.getInt("id_country"));
                ordersDataList.add(ordersData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordersDataList;
    }

    @Override
    public OrdersData getOrderById(int id) {
        OrdersData ordersData = null;

        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ordersData = new OrdersData();
                ordersData.setOrderId(rs.getInt("id_order"));
                ordersData.setUserId(rs.getInt("id_user"));
                ordersData.setTourId(rs.getInt("id_tour"));
                ordersData.setCountryId(rs.getInt("id_country"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return ordersData;
    }

    @Override
    public boolean deleteOrderById(int id) {

        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_ID)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean updateOrder(OrdersData ordersData) {
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER)) {


            preparedStatement.setInt(1, ordersData.getUserId());
            preparedStatement.setInt(2, ordersData.getTourId());
            preparedStatement.setInt(3, ordersData.getOrderId());
            preparedStatement.setInt(4,ordersData.getCountryId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public OrdersData getOrderByUserId(int id) {

        OrdersData ordersData = null;


        try(Connection connection = dataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_USER_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ordersData = new OrdersData();

                ordersData.setCountryId(rs.getInt("id_country"));
                ordersData.setOrderId(rs.getInt("id_order"));
                ordersData.setUserId(rs.getInt("id_user"));
                ordersData.setTourId(rs.getInt("id_tour"));

            }



        }catch (SQLException e){
            e.printStackTrace();
        }



        return null;
    }
}
