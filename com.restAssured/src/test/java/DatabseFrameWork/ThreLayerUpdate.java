package DatabseFrameWork;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.DatabaseLibrary;
import genericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objectRepo.CreateProjectLocators;
import objectRepo.HomePageLocator;
import objectRepo.LoginPageLocators;

public class ThreLayerUpdate {

	
	@Test 
	public void createProject() throws SQLException {
		JavaUtility jlib = new JavaUtility();
		DatabaseLibrary dlib = new DatabaseLibrary();
		//Launching Browser
		WebDriver cd = new ChromeDriver();
		cd.get("http://rmgtestingserver:8084/");
		
		//Login to the application
		String user = "rmgyantra";
		String pass= "rmgy@9999";
		LoginPageLocators lp = new LoginPageLocators(cd);
		lp.loginactions(user, pass);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//homeactions
		HomePageLocator hlp = new HomePageLocator(cd);
		hlp.homeActions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hlp.createProjectClick();
		
		//Project Creation
		String projectName = "Kurush"+jlib.getRandomNum();
		String createBy = "Kuresh";
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CreateProjectLocators cpl = new CreateProjectLocators(cd);
		cpl.createProject(projectName, createBy);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ab = cd.findElement(By.xpath("//td[text()='"+projectName+"']/preceding-sibling::td"));
		String ProjectId = ab.getText();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cd.close();
		
		//updating Project USing 
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", createBy);
		jObj.put("projectName", projectName);
		jObj.put("status", "Completed");
		jObj.put("teamSize",5);
		
		baseURI = "http://rmgtestingserver:8084";
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jObj);
		reqs.contentType(ContentType.JSON);
		Response res = reqs.put("http://rmgtestingserver:8084/projects/"+ProjectId);

		res.then().log().all();
		dlib.connectDBcon();
		String query = "select * from project";
		String actData = dlib.executeQueryAndGetData(query, ProjectId, 1);
		dlib.closeDbConnection();				
	}
}
