package genericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
	public static DatabaseLibrary dlib = new DatabaseLibrary();
	public static JavaUtility jlib = new JavaUtility();
	public RestAssuredLibrary rlib = new  RestAssuredLibrary();
	public RequestSpecification req;
	public ResponseSpecification resp;
	@BeforeSuite
	public void config() throws SQLException {
		dlib.connectDBcon();
		req = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		ResponseSpecification resp = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.expectStatusCode(201).build();
	}
	
	@AfterSuite
	public void asConnfig() throws SQLException {
		dlib.closeDbConnection();
	}

}




