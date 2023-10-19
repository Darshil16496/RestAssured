package DatabseFrameWork;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.DatabaseLibrary;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;
import objectRepo.HomePageLocator;
import objectRepo.LoginPageLocators;

public class ThreeLayerAGD {
	
	@Test
	public void createProj() throws SQLException {
		JavaUtility jlib= new JavaUtility();
		DatabaseLibrary dlib = new DatabaseLibrary();
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		String projectName = "Darshu"+jlib.getRandomNum();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Kurush");
		jObj.put("projectName", projectName);
		jObj.put("status", "Completed");
		jObj.put("teamSize", 3);
		
		//Project Creation
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		//Step2 Actions
		.when()
		.post("/addProject").then().assertThat().statusCode(201).log().all();
		
		//LoginUsing Gui

		WebDriver cd = new ChromeDriver();
		
		cd.get("http://rmgtestingserver:8084/");
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
		HomePageLocator hlp = new HomePageLocator(cd);
		hlp.homeActions();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ab = cd.findElement(By.xpath("//td[text()='"+projectName+"']/preceding-sibling::td"));
		String ProjectId = ab.getText();
		System.out.println(ProjectId);
		cd.close();
		//Validatin using db
		dlib.connectDBcon();
		String query = "select * from project";
		String actData = dlib.executeQueryAndGetData(query, ProjectId, 1);
		dlib.closeDbConnection();		
	}

}
