package crudReqrewithBDD;

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
		baseURI = "https://reqres.in/";
		JavaUtility jlib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Kuru4");
		jobj.put("job", "leader4");
		
		//Step :- PreConditions
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//Step2 Actions
		.when()
		.put("/api/users/7")
		
		//step 3 Validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log()
		.all();
	}
}
