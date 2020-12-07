package UnitTest;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.*;
import DB.DBHelper;

@TestMethodOrder(OrderAnnotation.class)
public class Testing {

	public int i = 0;
	@Test
	@Order(1)
	public void testGetData() {
		ArrayList data = null;
		try {
			DBHelper db = new DBHelper();
			data = db.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(data instanceof ArrayList);
	}
	
	
	@Test
	@Order(2)
	public void testInsertData1() {
		boolean f = false;
		try {
			DBHelper db = new DBHelper();
			if(db.status)
				f = db.insertData(3, "Akash", "FE", "9876543211", "Pimpri");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(f);
	}
	
	@Test
	@Order(3)
	public void testInsertData2() {
		boolean f = false;
		try {
			DBHelper db = new DBHelper();
			if(db.status)
				f = db.insertData(3, "Akash", "FE", "9876543211", "Pimpri");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(f);
	}
	
	@Test
	@Order(4)
	public void testDeleteRecord1() {
		boolean f = false;
		try {
			DBHelper db = new DBHelper();
			if(db.status)
				f = db.deleteRecord(3);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(f);
	}
	
	@Test
	@Order(5)
	public void testDeleteRecord2() {
		boolean f = false;
		try {
			DBHelper db = new DBHelper();
			if(db.status)
				f = db.deleteRecord(4);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(f);
	}
	
}

