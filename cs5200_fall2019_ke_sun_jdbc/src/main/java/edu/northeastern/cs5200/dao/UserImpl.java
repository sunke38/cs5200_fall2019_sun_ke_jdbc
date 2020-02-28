package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import edu.northeastern.cs5200.model.User;

public class UserImpl implements UserDao{
	private Connection conn;
	public UserImpl(Connection db){
		this.conn=db;
	};
	public void createUser(User user) {
		// TODO Auto-generated method stub
		if (conn == null) {
            System.err.println("DB connection failed");
            return;
        }
        String sql = "INSERT INTO person (Id,firstName,lastName,username,password,email,dob) VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getFristname());
            statement.setString(3, user.getLastname());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getEmail());
            statement.setDate(7, new java.sql.Date(user.getDob().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "INSERT INTO user (Id,userAgreement,Id_Person) VALUES (?,?,?);";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, user.getId());
            statement.setBoolean(2, user.isUserAgreement());
            statement.setLong(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "INSERT INTO address (Id,street1,street2,city,state,zip,primary_address,Id_Person) VALUES (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getStree1());
            statement.setString(3, user.getStree2());
            statement.setString(4, user.getCity());
            statement.setString(5, user.getState());
            statement.setString(6, user.getZip());
            statement.setLong(7, 1);
            statement.setLong(8, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "INSERT INTO phone (Id,Phone,primary_Phone,Id_Person) VALUES (?,?,?,?);";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getPhone());
            statement.setLong(3, 1);
            statement.setLong(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	
}
