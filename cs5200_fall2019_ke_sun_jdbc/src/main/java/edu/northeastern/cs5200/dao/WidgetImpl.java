package edu.northeastern.cs5200.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.*;
import edu.northeastern.cs5200.model.Website;
import edu.northeastern.cs5200.model.Widget;
import edu.northeastern.cs5200.model.Widget.Type;

public class WidgetImpl implements WidgetDao{
	private Connection conn;
	public WidgetImpl(Connection db){
		this.conn=db;
	};
	@Override
	public void createWidgetForPage(int pageId, Widget widget) {
		// TODO Auto-generated method stub
		   String sql = "INSERT INTO widget (Id,name,type,text,orders,width,height,url,Id_page,shareble,expandable) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	        try {
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, widget.getId());
	            statement.setString(2, widget.getName());
	            statement.setString(3, widget.getType().type);
	            statement.setString(4, widget.getText());
	            statement.setInt(5, widget.getOrders());
	            statement.setInt(6, widget.getWidth());
	            statement.setInt(7, widget.getHeght());
	            statement.setString(8, widget.getUrl());
	            statement.setInt(9, pageId);
	            statement.setBoolean(10, widget.isShareble());
	            statement.setBoolean(11, widget.isExpandable());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Widget> findAllWidgets() {
		// TODO Auto-generated method stub
		List<Widget> ret = new ArrayList<>();
        String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.widget";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            //Widget(int id, String name, int width, int heght, String cssClass, String cssStyle, String text, int orders,Type type, int size, String html, String src, String url, boolean shareble, boolean expandable)
            while (rs.next()) {
            	Widget widget = new Widget(rs.getInt("Id"), rs.getString("name"), rs.getInt("width"), rs.getInt("height"), rs.getString("cssClass"), rs.getString("cssStyle"), rs.getString("text"), rs.getInt("orders"), Widget.getType(rs.getString("type")), rs.getString("url"), rs.getBoolean("shareble"), rs.getBoolean("expandable"));
                ret.add(widget);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ret;
	}

	@Override
	public Widget findWidgetById(int widgetId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.widget where Id = ?";
		Widget widget = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, widgetId);
            ResultSet rs = statement.executeQuery();
            //Widget(int id, String name, int width, int heght, String cssClass, String cssStyle, String text, int orders,Type type, int size, String html, String src, String url, boolean shareble, boolean expandable)
            while (rs.next()) {
            	widget = new Widget(rs.getInt("Id"), rs.getString("name"), rs.getInt("width"), rs.getInt("height"), rs.getString("cssClass"), rs.getString("cssStyle"), rs.getString("text"), rs.getInt("orders"), Widget.getType(rs.getString("type")), rs.getString("url"), rs.getBoolean("shareble"), rs.getBoolean("expandable"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return widget;
	}

	@Override
	public List<Widget> findWidgetsForPage(int pageId) {
		// TODO Auto-generated method stub
		List<Widget> ret = new ArrayList<>();
        String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.widget where Id_page = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pageId);
            ResultSet rs = statement.executeQuery();
            //Widget(int id, String name, int width, int heght, String cssClass, String cssStyle, String text, int orders,Type type, int size, String html, String src, String url, boolean shareble, boolean expandable)
            while (rs.next()) {
            	Widget widget = new Widget(rs.getInt("Id"), rs.getString("name"), rs.getInt("width"), rs.getInt("height"), rs.getString("cssClass"), rs.getString("cssStyle"), rs.getString("text"), rs.getInt("orders"), Widget.getType(rs.getString("type")), rs.getString("url"), rs.getBoolean("shareble"), rs.getBoolean("expandable"));
                ret.add(widget);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ret;
	}

	@Override
	public int updateWidget(int widgetId, Widget widget) {
		// TODO Auto-generated method stub
		String sql = "UPDATE cs5200_fall2019_sun_ke_jdbc.widget SET name=?,type=?,text=?,orders=?,width=?,height=?,url=?,shareble=?,expandable=? where Id = ?;";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            
            statement.setString(1, widget.getName());
            statement.setString(2, widget.getType().type);
            statement.setString(3, widget.getText());
            statement.setInt(4, widget.getOrders());
            statement.setInt(5, widget.getWidth());
            statement.setInt(6, widget.getHeght());
            statement.setString(7, widget.getUrl());
            statement.setBoolean(8, widget.isShareble());
            statement.setBoolean(9, widget.isExpandable());
            statement.setInt(10, widgetId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public int deleteWidget(int widgetId) {
		String sql = "DELETE FROM cs5200_fall2019_sun_ke_jdbc.widget WHERE Id=?";
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, widgetId);
            statement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

}
