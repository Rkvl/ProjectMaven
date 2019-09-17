package models.dao;

import models.datas.UserData;

import java.util.List;

public interface UserDao {

    UserData getUserById(int id);

    List<UserData> getAllUsers();

    boolean deleteUserById(int id);

   void createUser( String name, String lastName, String password, String email, int status);

   boolean updateUser(UserData userdata);

}
