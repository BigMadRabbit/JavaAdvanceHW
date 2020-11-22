package by.womework;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {			
			System.out.println( "Error Driver");
		}
    	
    	DataBase database = new DataBase("Conf");
    	try {
			database.getConnection();
			System.out.println( "Connected");		
		} catch (IOException e) {
			System.out.println( "Error to Connect");
		}	
    	
    	for(int i=0;i<args.length;i++) {
    		try {
    			database.insertValue(args[0]);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		};    		
    	}   
    	
    	System.out.println( "----- Values In Base -----");
    	
    	try {
			database.readDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
