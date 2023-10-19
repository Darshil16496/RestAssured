package crudReqrewithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetAllProject {
	@Test
	public void getAllProject() {
		baseURI = "https://reqres.in/";
			
			when()
			.get("/api/users?page=2")
			
			//step 3 Validation
			.then()
			.assertThat()
			.statusCode(200)
			.log()
			.all();
	}
}
