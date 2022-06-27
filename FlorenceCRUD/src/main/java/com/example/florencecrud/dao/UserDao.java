package com.example.florencecrud.dao;

import com.example.florencecrud.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Repository
public interface UserDao {

    public abstract String createUser(User User);
    public abstract User fetchUserById(Integer UserId) throws SQLException;
    public abstract List<User> fetchAllUsers() throws SQLException;
    public abstract String updateUserEmailById(String newEmail,Integer UserId);
    public abstract String deleteUserById(Integer UserId);
}
