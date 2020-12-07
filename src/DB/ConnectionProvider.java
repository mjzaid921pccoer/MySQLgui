package DB;
import java.sql.*;
public class ConnectionProvider {

	static String user = null;
	static String password = null;
	
	public static Connection connectToDB() {
		String dbUrl = "jdbc:mysql://localhost:3306/CSE";
		Connection connection = null;
		if(isUserSet() && isPasswordSet()) {
			try {
				connection = DriverManager.getConnection(dbUrl,user,password);
			} catch (Exception e) {
				return null;
				//e.printStackTrace();
			}	
		}else {
			System.out.println("Please set the login credentials...");
		}
		
		
		return connection;
	}
	
	public static boolean setUser(String username) {
		user = username;
		return true;
	}
	
	public static boolean setPassword(String pass) {
		password = pass;
		return true;
	}
	
	static boolean isUserSet() {
		return user != null ? true : false;
	}
	
	static boolean isPasswordSet() {
		return password != null ? true : false;
	}
	
	
	public static void main(String[] args) {
		System.out.println(connectToDB());
	}
}
