package com.example.florencecrud.controller;

import com.example.florencecrud.dao.UserDao;
import com.example.florencecrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

;
    @RestController
    public class UserController {

        @Autowired
        UserDao userDao;

        @GetMapping("/Users")
        public List<User> findAll() throws SQLException {
            return userDao.fetchAllUsers();
        }

        @GetMapping("/Users/{id}")
        public User findById(@PathVariable int id) throws SQLException {
            return userDao.fetchUserById(id);
        }

        @DeleteMapping("/Users/{id}")
        public String deleteById(@PathVariable int id) {
            String esito;
            esito=userDao.deleteUserById(id);
            if ("OK".equals(esito)) {
                return esito+" - User deleted from the database successfully";
            } else {
                return esito;
            }
        }

        @PostMapping("/Users")
        public String save(@RequestBody User e) {
            String esito;
            esito = userDao.createUser(e);
            if ("OK".equals(esito)) {
                return esito+" - User created successfully";
            } else {
                return esito;
            }
        }

        @PutMapping("/Users/{id}")
        public String update(@RequestBody User e, @PathVariable int id) {
            String esito;
            esito=userDao.updateUserEmailById(e.getEmail(), id);

            if ("OK".equals(esito)) {
                return esito + " - User updated successfully";
            } else {
                return esito;
            }
        }


    }
