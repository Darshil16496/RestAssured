package crudWithRmgBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetAllProject {
	@Test
	public void getAllProject() {
			baseURI = "http://rmgtestingserver";
			port = 8084;
			//
			when()
			.get("/projects")
			
			//step 3 Validation
			.then()
			.assertThat()
			.statusCode(200)
			.log()
			.all();
	}
}
