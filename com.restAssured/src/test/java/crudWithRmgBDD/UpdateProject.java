package crudWithRmgBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class UpdateProject {
	@Test
	public void updateProject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaUtility jlib = new JavaUtility();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Kuresh");
		jObj.put("projectName", "Kurush1"+jlib.getRandomNum());
		jObj.put("status", "On Going");
		jObj.put("teamSize", 9);
		
		//Step :- PreConditions
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		//Step2 Actions
		.when()
		.put("/projects/TY_PROJ_75421")
		
		//step 3 Validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log()
		.all();
	}
}
