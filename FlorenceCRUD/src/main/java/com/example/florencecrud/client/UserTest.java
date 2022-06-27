package com.example.florencecrud.client;

import com.example.florencecrud.model.User;
import com.example.florencecrud.service.UserService;
import com.example.florencecrud.service.UserServiceImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class UserTest {

    public static void main(String[] args) {

        AbstractApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            UserService UserService = ctx.getBean(UserServiceImpl.class);
            createUser(UserService);
            //getUserById(UserService);
            //fetchAllUsersInfo(UserService);
            //UserService.updateUserEmailById("kk.cs@gmail.com", 2);
            UserService.deleteUserById(2);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ctx != null)
                ctx.close();
        }
    }

    private static void fetchAllUsersInfo(UserService UserService) throws SQLException {
        UserService.getAllUsers().forEach(System.out::println);
    }

    private static void getUserById(UserService UserService) throws SQLException {
        User User = UserService.getUserById(1);
        System.out.println(User);
    }

    private static void createUser(UserService UserService) {
        User User = getUser() ;
        UserService.createUser(User);
    }

    private static User getUser() {
        User User = new User();
        User.setNome("KK");
        User.setCognome("");
        User.setEmail("kk.m@gmail.com");
        User.setIndirizzo("Male");
        return User;
    }
}
