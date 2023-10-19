package DatabseFrameWork;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.DatabaseLibrary;
import genericUtility.JavaUtility;
import objectRepo.CreateProjectLocators;
import objectRepo.HomePageLocator;
import objectRepo.LoginPageLocators;

public class ThreeLayerGAD {

	@Test
	public void createProject() throws InterruptedException, SQLException  {
		JavaUtility jlib= new JavaUtility();
		DatabaseLibrary dlib = new DatabaseLibrary();
		//Launching The browser
		WebDriver cd = new ChromeDriver();
		cd.get("http://rmgtestingserver:8084/");
		cd.manage().window().maximize();
		
		//Login To the Appication
		String user = "rmgyantra";
		String pass= "rmgy@9999";
		LoginPageLocators lp = new LoginPageLocators(cd);
		lp.loginactions(user, pass);
		Thread.sleep(3000);
		
		//After Login homePage Actions
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
		.delete("/projects/"+ProjectId).then().assertThat().statusCode(204).log().all();
		dlib.connectDBcon();
		String query = "select * from project";
		String actData = dlib.executeQueryAndGetData(query, ProjectId, 1);
		dlib.closeDbConnection();
	}
}
