package by.womework;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class DataBase {
	private final static String SELECTUSER = "SELECT * FROM `Users` WHERE `user`=? AND `password`=?";
	
	private String host;
	private String base;
	private String login;
	private String pass;
	private Connection conn;
	
	
	public DataBase() {
		host  = "localhost";
		base  = "JavaAdvance06";
		login = "root";
		pass  = "";	
	}
	
	public boolean getConnection() throws IOException  {   		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + base + "?name=" + login+ "&password=" + pass);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkUser(String user, String password) throws SQLException {
		boolean found = false;
				
		try (PreparedStatement ps = conn.prepareStatement(SELECTUSER);) {
			
			ps.setString(1, user);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			found = rs.next();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conn.close();
		return found;
	}
			
}
