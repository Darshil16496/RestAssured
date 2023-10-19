package DatabseFrameWork;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.BaseClass;
import objectRepo.CreateProjectLocators;
import objectRepo.HomePageLocator;
import objectRepo.LoginPageLocators;


public class AutomationScriptTest extends BaseClass{
	
	public static void main(String args[]) throws SQLException, Throwable {

		WebDriver cd = new ChromeDriver();
		
		cd.get("http://rmgtestingserver:8084/");
//		cd.findElement(By.id("usernmae")).sendKeys("rmgyantra");
//		cd.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
//		cd.findElement(By.xpath("//button[text()='Sign in']")).click();
		String user = "rmgyantra";
		String pass= "rmgy@9999";
		LoginPageLocators lp = new LoginPageLocators(cd);
		lp.loginactions(user, pass);
		Thread.sleep(3000);
		HomePageLocator hlp = new HomePageLocator(cd);
		hlp.homeActions();
		Thread.sleep(3000);
		hlp.createProjectClick();
		String projectName = "Kurush"+jlib.getRandomNum();
		String createBy = "Kuresh";
		Thread.sleep(1000);
		CreateProjectLocators cpl = new CreateProjectLocators(cd);
		cpl.createProject(projectName, createBy);
		Thread.sleep(2000);
		WebElement ab = cd.findElement(By.xpath("//td[text()='"+projectName+"']/preceding-sibling::td"));
		String ProjectId = ab.getText();
		Thread.sleep(2000);
		cd.close();
		baseURI = "http://rmgtestingserver:8084";
		when()
		.get("/projects/"+ProjectId).then().assertThat().statusCode(200).log().all();
		dlib.connectDBcon();
		String query = "select * from project";
		String actData = dlib.executeQueryAndGetData(query, ProjectId, 1);
		dlib.closeDbConnection();				
		
	}
	
}
