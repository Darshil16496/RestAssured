package crudWithRmgBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetProject {

	@Test
	public void getProject() {
		baseURI = "https://reqres.in/";
		port = 8084;
		when()
		.get("/projects/TY_PROJ_75421")
		
		//step 3 Validation
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}
}
