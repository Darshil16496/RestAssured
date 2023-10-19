package crudReqrewithBDD;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;
public class DeleteProject {
	@Test
	public void deleteProject() {
		
		baseURI = "https://reqres.in/";
		when()
		.delete("api/users/950")
		
		//step 3 Validation
		.then()
		.assertThat()
		.statusCode(204)
		.log()
		.all();
	}

}
