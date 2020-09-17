package pack;

import java.sql.*;
public class DbConnection {
	
	private static Connection conn;
	
	static{
		try{
	    Class.forName("com.mysql.jdbc.Driver");
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "5678");
	    }
		catch(Exception E){
		E.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		
		return conn;
	
	}

}
