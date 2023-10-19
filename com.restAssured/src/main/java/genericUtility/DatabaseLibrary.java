package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.BeforeSuite;
import com.mysql.jdbc.Driver;

public class DatabaseLibrary {

	Driver driver;
	Connection con;
	
	//@BeforeSuite
	public void connectDBcon() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(Iconstants.dbURL, Iconstants.dbUserName, Iconstants.dbPassword);
	}
	
	public String executeQueryAndGetData(String query, String Expdata, int columnNum) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String data =result.getString(columnNum);
			if(data.equalsIgnoreCase(Expdata)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("Data is Verified");
			return Expdata;
		}else {
			System.out.println("Data is not Verified");
			return Expdata;
		}
	}
	
	/**
	 * This Method is used to Close the Connection
	 * @author Darshil
	 * @throws SQLException
	 */
	public void closeDbConnection() throws SQLException {
		con.close();
	}
}
