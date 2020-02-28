package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.model.Role;

public class RoleImpl implements RoleDao {
	private Connection conn;
	public RoleImpl(Connection db){
		this.conn=db;
	};
	@Override
	public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO cs5200_fall2019_sun_ke_jdbc.website_role (Id_developer,Id_website,role) VALUES (?,?,?);";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, developerId);
	            statement.setInt(2, websiteId);
	            statement.setString(3, Role.roleIdtoString(roleId));
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	}

	@Override
	public void assignPageRole(int developerId, int pageId, int roleId) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO cs5200_fall2019_sun_ke_jdbc.page_role (Id_developer,Id_page,role) VALUES (?,?,?);";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, developerId);
	            statement.setInt(2, pageId);
	            statement.setString(3, Role.roleIdtoString(roleId));
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cs5200_fall2019_sun_ke_jdbc.website_role WHERE Id_developer=? and Id_website=? and role=?";
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, developerId);
            statement.setInt(2, websiteId);
            statement.setString(3, Role.roleIdtoString(roleId));
            statement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deletePageRole(int developerId, int pageId, int roleId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cs5200_fall2019_sun_ke_jdbc.page_role WHERE Id_developer=? and Id_page=? and role=?";
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, developerId);
            statement.setInt(2, pageId);
            statement.setString(3, Role.roleIdtoString(roleId));
            statement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
