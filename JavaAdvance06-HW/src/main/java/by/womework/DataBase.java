package by.womework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;



public class DataBase {
	private final static String INSERT = "INSERT INTO `HomeWork06` (`Value`) VALUES (?);";
	private final static String SELECT = "SELECT `Id`, `Value` FROM `HomeWork06`";
	
	private String confFile;
	private String host;
	private String base;
	private String login;
	private String pass;
	private Connection conn;
	
	
	public DataBase(String confFile) {
		this.confFile = confFile;
		
	}
	
	public void getConnection() throws IOException  {
		
		FileInputStream fis = new FileInputStream(Paths.get(confFile + ".properties").toFile());
		ResourceBundle resourceBundle = new PropertyResourceBundle(fis);	
    	host  = resourceBundle.getString("MySQL_Host");
		base  = resourceBundle.getString("MySQL_Base");
		login = resourceBundle.getString("MySQL_login");
		pass  = resourceBundle.getString("MySQL_Passd");
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + base + "?user=" + login+ "&password=" + pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void readDB() throws SQLException {
		PreparedStatement reader = conn.prepareStatement(SELECT);
		ResultSet resultSet = reader.executeQuery();
		
		while(resultSet.next()) {
            System.out.println(resultSet.getString("Id") + " : " + resultSet.getString("Value") );
		}		
		
		resultSet.close();
		reader.close();
	}
	
	public void insertValue(String value) throws SQLException {
		PreparedStatement inserter = conn.prepareStatement(INSERT);
		
		inserter.setString(1, value);		
		inserter.close();
	}


}
