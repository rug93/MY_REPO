package com.example.florencecrud.service;

import com.example.florencecrud.model.User;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface UserService {

    public abstract void createUser(User User);
    public abstract User getUserById(Integer UserId) throws SQLException;
    public abstract List<User> getAllUsers() throws SQLException;
    public abstract void updateUserEmailById(String newEmail,Integer UserId);
    public abstract void deleteUserById(Integer UserId);
}
