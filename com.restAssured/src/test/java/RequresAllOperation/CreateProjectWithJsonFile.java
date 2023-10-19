package RequresAllOperation;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectWithJsonFile {

	@Test
	public void createProject() {
		baseURI = "https://reqres.in";
		
		File file = new File(".\\resources\\jsonRequres.json");
		
		//Step 1:- Pre condition
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		//Step 2:- Actions
		.when()
		.post("/api/user")
		
		//Step:- 3 Validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
		
		
	}
}
