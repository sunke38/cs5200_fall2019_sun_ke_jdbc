package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.MySQLConnection;
import edu.northeastern.cs5200.model.Developer;

public class DeveloperImpl implements DeveloperDao{
	private Connection conn;
	public DeveloperImpl(Connection db){
		this.conn=db;
	};
	public void createDeveloper(Developer developer) {
		if (conn == null) {
            System.err.println("DB connection failed");
            return;
        }
        String sql = "INSERT INTO person (Id,firstName,lastName,username,password,email,dob) VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, developer.getId());
            statement.setString(2, developer.getFristname());
            statement.setString(3, developer.getLastname());
            statement.setString(4, developer.getUsername());
            statement.setString(5, developer.getPassword());
            statement.setString(6, developer.getEmail());
            statement.setDate(7, new java.sql.Date(developer.getDob().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "INSERT INTO developer (Id,developerkey,Id_Person) VALUES (?,?,?);";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, developer.getId());
            statement.setString(2, developer.getDeveloperKey());
            statement.setLong(3, developer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "INSERT INTO address (Id,street1,street2,city,state,zip,primary_address,Id_Person) VALUES (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, developer.getId());
            statement.setString(2, developer.getStree1());
            statement.setString(3, developer.getStree2());
            statement.setString(4, developer.getCity());
            statement.setString(5, developer.getState());
            statement.setString(6, developer.getZip());
            statement.setLong(7, 1);
            statement.setLong(8, developer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "INSERT INTO phone (Id,Phone,primary_Phone,Id_Person) VALUES (?,?,?,?);";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, developer.getId());
            statement.setString(2, developer.getPhone());
            statement.setLong(3, 1);
            statement.setLong(4, developer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public List<Developer> findAllDevelopers() {
		// TODO Auto-generated method stub
		if (conn == null) {
            System.err.println("DB connection failed");
            return new ArrayList<>();
        }

		List<Developer> ret = new ArrayList<>();
        String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.person join cs5200_fall2019_sun_ke_jdbc.developer on developer.Id_Person = person.Id left join cs5200_fall2019_sun_ke_jdbc.phone on phone.Id_Person = person.Id left join cs5200_fall2019_sun_ke_jdbc.address on address.Id_Person = person.Id";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	//(int id, String fristname, String lastname, String username, String password, String email,Date dob,String developerKey)
            	Developer dev = new Developer((int) rs.getLong("Id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getDate("dob"),rs.getString("developerKey"));
            	dev.setPhone(rs.getString("phone"));
            	dev.setStree1(rs.getString("street1"));
            	dev.setStree2(rs.getString("street2"));
            	dev.setCity(rs.getString("city"));
            	dev.setState(rs.getString("state"));
            	dev.setZip(rs.getString("zip"));
                ret.add(dev);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ret;
	}
	public Developer findDeveloperById(int developerId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.person join cs5200_fall2019_sun_ke_jdbc.developer on developer.Id_Person = person.Id left join cs5200_fall2019_sun_ke_jdbc.phone on phone.Id_Person = person.Id left join cs5200_fall2019_sun_ke_jdbc.address on address.Id_Person = person.Id where developer.Id=?";
		Developer dev = new Developer();
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, developerId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
            dev = new Developer((int) rs.getLong("Id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getDate("dob"),rs.getString("developerKey"));
            dev.setPhone(rs.getString("phone"));
        	dev.setStree1(rs.getString("street1"));
        	dev.setStree2(rs.getString("street2"));
        	dev.setCity(rs.getString("city"));
        	dev.setState(rs.getString("state"));
        	dev.setZip(rs.getString("zip"));}
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return dev;
	}
	public Developer findDeveloperByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.person join cs5200_fall2019_sun_ke_jdbc.developer on developer.Id_Person = person.Id left join cs5200_fall2019_sun_ke_jdbc.phone on phone.Id_Person = person.Id left join cs5200_fall2019_sun_ke_jdbc.address on address.Id_Person = person.Id where person.username=?";
		Developer dev = new Developer();
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
            dev = new Developer((int) rs.getLong("Id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getDate("dob"),rs.getString("developerKey"));
            dev.setPhone(rs.getString("phone"));
        	dev.setStree1(rs.getString("street1"));
        	dev.setStree2(rs.getString("street2"));
        	dev.setCity(rs.getString("city"));
        	dev.setState(rs.getString("state"));
        	dev.setZip(rs.getString("zip"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return dev;
	}
	public Developer findDeveloperByCredentials(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM cs5200_fall2019_sun_ke_jdbc.person join cs5200_fall2019_sun_ke_jdbc.developer on developer.Id_Person = person.Id left join cs5200_fall2019_sun_ke_jdbc.phone on phone.Id_Person = person.Id left join cs5200_fall2019_sun_ke_jdbc.address on address.Id_Person = person.Id where person.username=? and person.password=?";
		Developer dev = new Developer();
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
            dev = new Developer((int) rs.getLong("Id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getDate("dob"),rs.getString("developerKey"));
            dev.setPhone(rs.getString("phone"));
        	dev.setStree1(rs.getString("street1"));
        	dev.setStree2(rs.getString("street2"));
        	dev.setCity(rs.getString("city"));
        	dev.setState(rs.getString("state"));
        	dev.setZip(rs.getString("zip"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return dev;
	}
	public int updateDeveloper(int developerId, Developer developer) {
		// TODO Auto-generated method stub
		if (conn == null) {
            System.err.println("DB connection failed");
            return -1;
        }
        String sql = "UPDATE cs5200_fall2019_sun_ke_jdbc.person SET firstName=?,lastName=?,username=?,password=?,email=?,dob=? where Id = ?;";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, developer.getFristname());
            statement.setString(2, developer.getLastname());
            statement.setString(3, developer.getUsername());
            statement.setString(4, developer.getPassword());
            statement.setString(5, developer.getEmail());
            statement.setDate(6, new java.sql.Date(developer.getDob().getTime()));
            statement.setLong(7, developer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "UPDATE cs5200_fall2019_sun_ke_jdbc.developer SET developerkey=?,Id_Person=? where Id = ?;";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, developer.getDeveloperKey());
            statement.setLong(2, developer.getId());
            statement.setLong(3, developer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "UPDATE cs5200_fall2019_sun_ke_jdbc.address SET street1=?,street2=?,city=?,state=?,zip=?,primary_address=? where Id_Person = ?;";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, developer.getStree1());
            statement.setString(2, developer.getStree2());
            statement.setString(3, developer.getCity());
            statement.setString(4, developer.getState());
            statement.setString(5, developer.getZip());
            statement.setLong(6, 1);
            statement.setLong(7, developer.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "UPDATE cs5200_fall2019_sun_ke_jdbc.phone SET Phone=?,primary_Phone=? where Id_Person=?;";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, developer.getPhone());
            statement.setLong(2, 1);
            statement.setLong(3, developer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}
	public int deleteDeveloper(int developerId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cs5200_fall2019_sun_ke_jdbc.person WHERE Id=?";
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, developerId);
            statement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}
	public int deleteDeveloperPrimaryAddress(int developerId) {
		String sql = "DELETE FROM cs5200_fall2019_sun_ke_jdbc.address WHERE Id=?";
		try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, developerId);
            statement.executeUpdate();
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}
	 
}
