package models.impl;

import connection.DataBaseConnection;
import models.dao.RoleDao;
import models.datas.RoleData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultRoleDao implements RoleDao {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();


    private static final String GET_ALL_USERS = "SELECT * FROM status WHERE user = 1 LIMIT 1";
    private static final String GET_ALL_ADMINS = "SELECT * From status WHERE admin = 2 LIMIT ONLY 2";
    private static final String GET_ALL_USERS_AT_ALL = " SELECT * FROM status";
    private static final String GET_USER_BY_ID = "SELECT * FROM status WHERE id_user = ?";
    private static final String UPDDATE_USER_ROLE = "UPDATE status SET user = ?, admin = ?, id_user = ?";
    private static final String DELETE_USER = "DELETE FROM status WHERE id_user = ?";


    @Override
    public RoleData getUserById(int id) {
        RoleData roleData = null;


        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID)) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                roleData = new RoleData();

                roleData.setAdminRole(rs.getInt("admin"));
                roleData.setUserRole(rs.getInt("user"));
                roleData.setUserId(rs.getInt("id_user"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roleData;

    }

    @Override
    public boolean updateUserRole(RoleData roleData) {

        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDDATE_USER_ROLE)) {
            statement.setInt(1,roleData.getAdminRole());
            statement.setInt(2,roleData.getUserRole());
            statement.setInt(3, roleData.getUserId());

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }


    @Override
    public List<RoleData> getAllUsers() {
        List<RoleData> roleDataList = new ArrayList<>();
        RoleData roleData = null;


        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                roleData = new RoleData();
                roleData.setUserRole(rs.getInt("user"));
                roleData.setUserId(rs.getInt("id_user"));
                roleDataList.add(roleData);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roleDataList;
    }

    @Override
    public List<RoleData> getAllAdmins() {

        List<RoleData> roleDataList = new ArrayList<>();
        RoleData roleData = null;


        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_ADMINS)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                roleData = new RoleData();
                roleData.setAdminRole(rs.getInt("admin"));
                roleData.setUserId(rs.getInt("id_user"));
                roleDataList.add(roleData);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return roleDataList;
    }

    @Override
    public List<RoleData> getAllUsersAtAll() {
        List<RoleData> roleDataList = new ArrayList<>();
        RoleData roleData = null;


        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS_AT_ALL)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                roleData = new RoleData();
                roleData.setUserId(rs.getInt("user"));
                roleData.setAdminRole(rs.getInt("admin"));
                roleData.setUserId(rs.getInt("id_user"));
                roleDataList.add(roleData);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return roleDataList;
    }

    @Override
    public boolean deleteUserById(int id) {

        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {


            statement.setInt(1,id);
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}
