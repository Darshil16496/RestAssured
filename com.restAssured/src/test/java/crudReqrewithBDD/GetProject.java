package crudReqrewithBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetProject {

	@Test
	public void getProject() {
		baseURI = "https://reqres.in/";
		when()
		.get("/api/users/8")
		
		//step 3 Validation
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}
}
