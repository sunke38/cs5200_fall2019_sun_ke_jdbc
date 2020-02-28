package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.model.Developer;
import edu.northeastern.cs5200.model.Website;

public class WebsiteImpl implements WebsiteDao{
	private Connection conn;
	public WebsiteImpl(Connection db){
		this.conn=db;
	};
	@Override
	public void createWebsiteForDeveloper(int developerId, Website website) {
		// TODO Auto-generated method stub
		   String sql = "INSERT INTO website (Id,Id_developer,name,description,created,updated,visits) VALUES (?,?,?,?,?,?,?);";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setLong(1, website.getId());
	            statement.setLong(2, developerId);
	            statement.setString(3, website.getName());
	            statement.setString(4, website.getDescription());
	            statement.setDate(5, new java.sql.Date(website.getCreated().getTime()));
	            statement.setDate(6, new java.sql.Date(website.getUpdated().getTime()));
	            statement.setLong(7, website.getVisits());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
/*CREATE TABLE website
(
Id Int,
Id_developer int,
name varchar(32),
description varchar(2048),
created Date,
updated Date,
visits Int,
PRIMARY KEY (Id),
FOREIGN KEY (Id_developer) REFERENCES developer(Id) ON DELETE CASCADE
);*/
	@Override
	public List<Website> findAllWebsites() {
		// TODO Auto-generated method stub
		List<Website> ret = new ArrayList<>();
        String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.website";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	//public Website(int id, String name, String description, Date created, Date updated, int visits)
            	Website web = new Website(rs.getInt("Id"),rs.getString("name"),rs.getString("description"),rs.getDate("created"),rs.getDate("updated"),rs.getInt("visits"));
                ret.add(web);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ret;
	}

	@Override
	public List<Website> findWebsitesForDeveloper(int developerId) {
		List<Website> ret = new ArrayList<>();
        String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.website where Id_developer = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, developerId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	//public Website(int id, String name, String description, Date created, Date updated, int visits)
            	Website web = new Website(rs.getInt("Id"),rs.getString("name"),rs.getString("description"),rs.getDate("created"),rs.getDate("updated"),rs.getInt("visits"));
                ret.add(web);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ret;
	}

	@Override
	public Website findWebsiteById(int websiteId) {
		// TODO Auto-generated method stub
		Website web = null;
        String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.website where Id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, websiteId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	//public Website(int id, String name, String description, Date created, Date updated, int visits)
            	web = new Website(rs.getInt("Id"),rs.getString("name"),rs.getString("description"),rs.getDate("created"),rs.getDate("updated"),rs.getInt("visits"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return web;
	}

	@Override
	public int updateWebsite(int websiteId, Website website) {
		// TODO Auto-generated method stub
		   String sql = "UPDATE website SET name=?,description=?,created=?,updated=?,visits=? where Id = ?;";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, website.getName());
	            statement.setString(2, website.getDescription());
	            statement.setDate(3, new java.sql.Date(website.getCreated().getTime()));
	            statement.setDate(4, new java.sql.Date(website.getUpdated().getTime()));
	            statement.setLong(5, website.getVisits());
	            statement.setLong(6, websiteId);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return 0;
	}

	@Override
	public int deleteWebsite(int websiteId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cs5200_fall2019_sun_ke_jdbc.website WHERE Id=?";
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, websiteId);
            statement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

}
