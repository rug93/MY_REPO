package com.example.florencecrud.dao;

import com.example.florencecrud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Service
public class UserDaoImpl implements UserDao  {

    @Override
    public String createUser(User user) {
        int update = 0;
        int id = user.getId();
        String nome = user.getNome();
        String cognome = user.getCognome();
        String email = user.getEmail();
        String indirizzo = user.getIndirizzo();
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","oracle");
            PreparedStatement stmt= conn.prepareStatement("INSERT INTO User(Id,Nome,cognome,email,Indirizzo) VALUES (?,?,?,?,?)");
            stmt.setInt(1,id);
            stmt.setString(2,nome);
            stmt.setString(3,cognome);
            stmt.setString(4,email);
            stmt.setString(5,indirizzo);
            update = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if(update == 1) {
            return "OK";
        }else {
            return "KO";
        }
    }

    @Override
    public User fetchUserById(Integer UserId) {

        User user = new User();

        try {
            Connection conn;
            ResultSet rs;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","oracle");
        PreparedStatement stmt= conn.prepareStatement("SELECT * FROM User WHERE Id = ?");
        stmt.setInt(1, UserId);
        rs = stmt.executeQuery();

        while (rs.next()) {
            user.setId(rs.getInt("ID"));
            user.setNome(rs.getString("NOME"));
            user.setCognome(rs.getString("COGNOME"));
            user.setEmail(rs.getString("EMAIL"));
            user.setIndirizzo(rs.getString("INDIRIZZO"));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
        return user;
    }

    @Override
    public List<User> fetchAllUsers() {
        List<User> userList = new ArrayList<>();
        String SQL = "SELECT * FROM ems.user";
        try {
            Connection conn;
            ResultSet rs;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","oracle");
            Statement stmt= conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setNome(rs.getString("NOME"));
                user.setCognome(rs.getString("COGNOME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setIndirizzo(rs.getString("INDIRIZZO"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }
    @Override
    public String updateUserEmailById(String newEmail, Integer UserId) {
        int update = 0;
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","oracle");
            PreparedStatement stmt= conn.prepareStatement("UPDATE user set email = ? WHERE Id = ?");
            stmt.setString(1,newEmail);
            stmt.setInt(2,UserId);
            update = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if(update == 1) {
            return "OK";
        }else {
            return "KO";
        }
    }
    @Override
    public String deleteUserById(Integer UserId) {
        int update = 0;
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","oracle");
            PreparedStatement stmt= conn.prepareStatement("DELETE FROM user WHERE Id = ?");
            stmt.setInt(1,UserId);
            update = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if(update == 1) {
            return "OK";
        }else {
            return "KO";
        }
    }
}
