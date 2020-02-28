package edu.northeastern.cs5200;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class MySQLConnection {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://cs5200-spring2020-sun.clwiyeialsqa.us-east-2.rds.amazonaws.com:3306/cs5200_fall2019_sun_ke_jdbc";
    private static final String USER = "cs5200";
    private static final String PASSWORD = "123456789";
    private static java.sql.Connection dbConnection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);

    if (dbConnection == null) {
        dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
        return dbConnection;
    } else { return dbConnection; } }
    
    public static void closeConnection() {
        try {
            if (dbConnection != null) {
        dbConnection.close();
        dbConnection = null; }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
