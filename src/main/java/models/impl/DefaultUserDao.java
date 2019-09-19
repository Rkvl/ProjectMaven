package models.impl;

import connection.DataBaseConnection;
import models.datas.UserData;
import models.dao.UserDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultUserDao implements UserDao {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();


    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id_user = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USER = "DELETE FROM users WHERE id_user = ?";
    private static final String CREATE_USER = "INSERT INTO users" +
            "(name, lastname, password, email, status) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE users SET name = ? , lastname = ?, password = ?," +
            " email = ?, status = ? WHERE id_user = ?";


    private static DefaultUserDao instance;


    public static synchronized DefaultUserDao getUserDaoInstance(){
        if(instance == null){
            instance = new DefaultUserDao();
        }
        return instance;
    }




    @Override
    public UserData getUserById(int id) {
        UserData userData = null;

        try (Connection conn = dataBaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_ID)) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userData = new UserData();
                userData.setIdUser(rs.getInt("id_user"));
                userData.setName(rs.getString("name"));
                userData.setLastName(rs.getString("lastname"));
                userData.setEmail(rs.getString("email"));
                userData.setPassword(rs.getString("password"));
                userData.setStatus(rs.getInt("status"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    @Override
    public List<UserData> getAllUsers() {
        List<UserData> userDataList = new ArrayList<>();
        UserData userData = null;

        try (Connection conn = dataBaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userData = new UserData();
                userData.setIdUser(rs.getInt("id_user"));
                userData.setName(rs.getString("name"));
                userData.setLastName(rs.getString("lastname"));
                userData.setEmail(rs.getString("email"));
                userData.setPassword(rs.getString("password"));
                userData.setStatus(rs.getInt("status"));
                userDataList.add(userData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDataList;
    }

    @Override
    public boolean deleteUserById(int id) {

        try (Connection conn = dataBaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(DELETE_USER);) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void createUser(String name, String lastName, String password, String email, int status) {
        try (Connection conn = dataBaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(CREATE_USER)) {


            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.setInt(5, status);

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean updateUser(UserData userData) {
        try (Connection conn = dataBaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE_USER)) {

            statement.setInt(1, userData.getIdUser());
            statement.setString(2, userData.getName());
            statement.setString(3, userData.getLastName());
            statement.setString(4, userData.getPassword());
            statement.setString(5, userData.getPassword());
            statement.setInt(6, userData.getStatus());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }


}
