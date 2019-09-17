package models.dao;

import models.datas.RoleData;

import java.util.List;

public interface RoleDao {

    RoleData getUserById(int id);

    boolean updateUserRole(RoleData roleData);

    List<RoleData> getAllUsers();

    List<RoleData> getAllAdmins();

    List<RoleData> getAllUsersAtAll();

    boolean deleteUserById(int id);


}
