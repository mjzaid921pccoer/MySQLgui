package DB;
import java.sql.SQLException;
import java.util.*;

public class Try {

	public static void main(String[] args) throws SQLException{
		DBHelper db = new DBHelper();
		ArrayList<ArrayList<String>> data = null;
		System.out.println("Status: "+db.status);
		if(db.status) {
			System.out.println(db.insertData(3, "Akash", "FE", "9876543211", "Pimpri"));
			
			data = db.getData();
			printData(data);
			
			System.out.println(db.deleteRecord(3));
			
			data = db.getData();
			printData(data);
		
		}
			

	}

	static void printData(ArrayList<ArrayList<String>> data) {
		for(ArrayList<String> a : data) {
			for(String s : a) {
				System.out.print("\t"+s);
			}
			System.out.println();
		}
	}
	
}
