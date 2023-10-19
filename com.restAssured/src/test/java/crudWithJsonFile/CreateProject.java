package crudWithJsonFile;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject {
	@Test
	public void createProj() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		File file = new File(".\\src\\test\\resources\\jsonFile.json");
		//Step :- PreConditionste
		given()
		.body(file)
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
