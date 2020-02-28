package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.model.Page;
import edu.northeastern.cs5200.model.Website;

public class PageImpl implements PageDao {
	private Connection conn;
	public PageImpl(Connection db){
		this.conn=db;
	};
	@Override
	public void createPageForWebsite(int websiteId, Page page) {
		// TODO Auto-generated method stub
		   String sql = "INSERT INTO page (Id,Id_website,title,description,created,updated,visits) VALUES (?,?,?,?,?,?,?);";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setLong(1, page.getId());
	            statement.setLong(2, websiteId);
	            statement.setString(3, page.getTitle());
	            statement.setString(4, page.getDescription());
	            statement.setDate(5, new java.sql.Date(page.getCreated().getTime()));
	            statement.setDate(6, new java.sql.Date(page.getUpdated().getTime()));
	            statement.setLong(7, page.getViews());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Page> findAllPages() {
		// TODO Auto-generated method stub
		List<Page> ret = new ArrayList<>();
        String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.page";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	//public Website(int id, String name, String description, Date created, Date updated, int visits)
            	Page page = new Page(rs.getInt("Id"),rs.getString("title"),rs.getString("description"),rs.getDate("created"),rs.getDate("updated"),rs.getInt("visits"));
                ret.add(page);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ret;
	}

	@Override
	public Page findPageById(int pageId) {
		// TODO Auto-generated method stub
		Page ret = null;
        String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.page where Id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pageId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	//public Website(int id, String name, String description, Date created, Date updated, int visits)
            	ret = new Page(rs.getInt("Id"),rs.getString("title"),rs.getString("description"),rs.getDate("created"),rs.getDate("updated"),rs.getInt("visits"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ret;
	}

	@Override
	public List<Page> findPagesForWebsite(int websiteId) {
		List<Page> ret = new ArrayList<>();
        String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.page where Id_website = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, websiteId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	//public Website(int id, String name, String description, Date created, Date updated, int visits)
            	Page page = new Page(rs.getInt("Id"),rs.getString("title"),rs.getString("description"),rs.getDate("created"),rs.getDate("updated"),rs.getInt("visits"));
                ret.add(page);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ret;
	}

	@Override
	public int updatePage(int pageId, Page page) {
		// TODO Auto-generated method stub
		   String sql = "UPDATE page SET title=?,description=?,created=?,updated=?,visits=? where Id = ?;";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, page.getTitle());
	            statement.setString(2, page.getDescription());
	            statement.setDate(3, new java.sql.Date(page.getCreated().getTime()));
	            statement.setDate(4, new java.sql.Date(page.getUpdated().getTime()));
	            statement.setLong(5, page.getViews());
	            statement.setLong(6, page.getId());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return 0;
	}

	@Override
	public int deletePage(int pageId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cs5200_fall2019_sun_ke_jdbc.page WHERE Id=?";
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pageId);
            statement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

}
