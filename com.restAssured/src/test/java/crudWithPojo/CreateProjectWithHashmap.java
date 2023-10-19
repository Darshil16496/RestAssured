package crudWithPojo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectWithHashmap {

	@Test
	public void createProj() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		HashMap<Object, Object> hm = new HashMap<Object, Object>();
		hm.put("createdBy", "Kurush");
		hm.put("projectName", "sdasdasdsad");
		hm.put("status", "Completed");
		hm.put("teamSize", 3);
		
		//Step :- PreConditions
		given()
		.body(hm)
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
