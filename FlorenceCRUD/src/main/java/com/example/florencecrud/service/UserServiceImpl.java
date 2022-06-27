package com.example.florencecrud.service;

import com.example.florencecrud.dao.UserDao;
import com.example.florencecrud.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao UserDao;

    public UserDao getUserDao() {
        return UserDao;
    }
    public void setUserDao(com.example.florencecrud.dao.UserDao UserDao) {
        this.UserDao = UserDao;
    }

    @Override
    public void createUser(User User) {
        getUserDao().createUser(User);
    }

    @Override
    public User getUserById(Integer UserId) throws SQLException {
        return getUserDao().fetchUserById(UserId);
    }
    @Override
    public List<User> getAllUsers() throws SQLException {
        return getUserDao().fetchAllUsers();
    }
    @Override
    public void updateUserEmailById(String newEmail, Integer UserId) {
        getUserDao().updateUserEmailById(newEmail, UserId);
    }
    @Override
    public void deleteUserById(Integer UserId) {
        getUserDao().deleteUserById(UserId);

    }
}
