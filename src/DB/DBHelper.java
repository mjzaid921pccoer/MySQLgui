package DB;
import java.sql.*;
import java.util.*;

public class DBHelper {

	Statement statement = null;
	PreparedStatement insertStatement = null;
	PreparedStatement deleteStatement = null;
	Connection con = null;
	public boolean status = false;
	public DBHelper() throws SQLException{
		 status = establishConnection("root", "");
		if(con!=null) {
			statement = con.createStatement();
			insertStatement = con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?)");
			deleteStatement = con.prepareStatement("DELETE FROM STUDENT WHERE roll=?");	
		}else {
			System.out.println("Invalid credentials...");
		}
		
	}
	
	boolean establishConnection(String username,String pass) {

		try {
			ConnectionProvider.setUser(username);
			ConnectionProvider.setPassword(pass);
			con = ConnectionProvider.connectToDB();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return con!=null ? true : false;
		
	}
	
	public ArrayList<ArrayList<String>> getData() throws SQLException {
		
		ArrayList<ArrayList<String>> resultData = new ArrayList();
		ArrayList<String> tempList = null;
		ResultSet rs = statement.executeQuery("Select * from student");
		ResultSetMetaData rsmd = rs.getMetaData();
		
		while(rs.next()) {
			tempList = new ArrayList<String>();
			for(int i =1 ; i <= rsmd.getColumnCount() ; i++) {
				//System.out.print("\t" + rs.getString(i));
				tempList.add(rs.getString(i));
			}
			resultData.add(tempList);
		}
		
		return resultData;
	}
	
	public boolean insertData(int roll, String name, String cls, String phone, String city)  {
		boolean status = false;
		try {
			insertStatement.setInt(1, roll);
			insertStatement.setString(2, name);
			insertStatement.setString(3, cls);
			insertStatement.setString(4, phone);
			insertStatement.setString(5, city);
			insertStatement.executeUpdate();
			//System.out.println("Count(insert): "+count);
			status = true;
		}catch(Exception e) {
			status = false;
		}
	
		return status;
	}
	
	public boolean deleteRecord(int roll) {
		
		int count = 0;
		try {
			deleteStatement.setInt(1, roll);
			count = deleteStatement.executeUpdate();	
			//System.out.println("Count(delete):"+count);
		}catch(Exception e) {
			//System.out.println("Exception occured while deletion...");
			e.printStackTrace();
		}
		
		return count != 0 ? true : false;
	}
	
}
