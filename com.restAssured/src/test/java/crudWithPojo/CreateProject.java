package crudWithPojo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import CreatePojoclass.CreatePojoClass;
import io.restassured.http.ContentType;

public class CreateProject {

	
	@Test
	public void createProj() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		CreatePojoClass cp = new CreatePojoClass("Kueush","Kuresh69","OnGoing", 8);
		//Step :- PreConditionste
		given()
		.body(cp)
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
