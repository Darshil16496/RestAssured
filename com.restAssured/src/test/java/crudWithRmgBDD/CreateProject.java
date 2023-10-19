package crudWithRmgBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProject {
@Test
	public void createProj() {
	
	baseURI = "http://rmgtestingserver";
	port = 8084;
	JavaUtility jlib = new JavaUtility();
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Kurush");
	jObj.put("projectName", "Darshu"+jlib.getRandomNum());
	jObj.put("status", "Completed");
	jObj.put("teamSize", 3);
	
	//Step :- PreConditions
	given()
	.body(jObj)
	.contentType(ContentType.JSON)
	
	//Step2 Actions
	.when()
	.post("/addProject")
	
	//step 3 Validation
	.then()
	.assertThat()
	.statusCode(201)
	.contentType(ContentType.JSON)
	.log()
	.all();
	
	
	
	}
}
