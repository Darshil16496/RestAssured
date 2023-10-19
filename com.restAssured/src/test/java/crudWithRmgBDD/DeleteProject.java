package crudWithRmgBDD;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;
public class DeleteProject {
	@Test
	public void deleteProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		//
		when()
		.delete("/projects/TY_PROJ_75421")
		
		//step 3 Validation
		.then()
		.assertThat()
		.statusCode(204)
		.log()
		.all();
	}

}
