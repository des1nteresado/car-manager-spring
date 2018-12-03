package com.des1nteresado.carmanager.dao;

import com.des1nteresado.carmanager.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> listUsers();
}
