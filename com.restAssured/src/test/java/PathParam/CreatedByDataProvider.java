package PathParam;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CreatePojoclass.CreatePojoClass;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class CreatedByDataProvider {
	@DataProvider(name = "getData")
	public Object[][] data(){
		Object[][] data =new Object[3][4];
		data[0][0] = "Kuresh";
		data[0][1] = "Dell";
		data[0][2] = "Completed";
		data[0][3] = 13;
		
		data[1][0] = "Prakash";
		data[1][1] = "HP";
		data[1][2] = "Completed";
		data[1][3] = 11;
		
		data[2][0] = "Sanat";
		data[2][1] = "Lenovo";
		data[2][2] = "Completed";
		data[2][3] = 4;
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public  void  createProjectData(String createdBy, String projectName, String status, int teamSize) {
		
		JavaUtility jlib = new JavaUtility();
		CreatePojoClass plib = new CreatePojoClass(createdBy, projectName+jlib.getRandomNum(), status, teamSize);
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		//Actions 
		.when()
		.post("/addProject")
		
		//Validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
	}
}
