package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import DB.DBHelper;

class TestingTestcases {

	@Test
	public void testGetData() {
		ArrayList data = null;
		try {
			DBHelper db = new DBHelper();
			data = db.getData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(data instanceof ArrayList);
	}
	
	
	@Test
	public void testInsertData1() {
		try {
			DBHelper db = new DBHelper();
			if(db.status)
			Assert.assertTrue(db.insertData(3, "Akash", "FE", "9876543211", "Pimpri"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertData2() {
		try {
			DBHelper db = new DBHelper();
			if(db.status)
			Assert.assertFalse((db.insertData(3, "Akash", "FE", "9876543211", "Pimpri")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteRecord() {
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

}
