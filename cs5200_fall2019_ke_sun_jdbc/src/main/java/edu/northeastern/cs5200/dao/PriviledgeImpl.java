package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.model.Role;

public class PriviledgeImpl implements PriviledgeDao {
	private Connection conn;
	public PriviledgeImpl(Connection db){
		this.conn=db;
	};
	@Override
	public void assignWebsitePrivilege(int developerId, int websiteId, String priviledge) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO cs5200_fall2019_sun_ke_jdbc.website_privilege (Id_developer,Id_website,privilege) VALUES (?,?,?);";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, developerId);
	            statement.setInt(2, websiteId);
	            statement.setString(3, priviledge);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO cs5200_fall2019_sun_ke_jdbc.page_privilege (Id_developer,Id_page,privilege) VALUES (?,?,?);";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, developerId);
	            statement.setInt(2, pageId);
	            statement.setString(3, priviledge);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM cs5200_fall2019_sun_ke_jdbc.website_privilege WHERE Id_developer=? and Id_website=? and priviledge=?";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, developerId);
	            statement.setInt(2, websiteId);
	            statement.setString(3, priviledge);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	}

	@Override
	public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM cs5200_fall2019_sun_ke_jdbc.page_privilege WHERE Id_developer=? and Id_page=? and priviledge=?";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, developerId);
	            statement.setInt(2, pageId);
	            statement.setString(3, priviledge);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

}
