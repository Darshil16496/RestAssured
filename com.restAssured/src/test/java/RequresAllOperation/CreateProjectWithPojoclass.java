package RequresAllOperation;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import CreatePojoclass.PojoClassRequres;
import io.restassured.http.ContentType;

public class CreateProjectWithPojoclass {

	@Test
	public void createProject() {
		baseURI = "https://reqres.in";
		PojoClassRequres cp = new PojoClassRequres("Darshu" , "Shivu");
		//Step 1: PreCondition
		given()
		.body(cp)
		.contentType(ContentType.JSON)
		
		//Step:- Actions
		.when()
		.post("/api/user")
		
		//Step :- Validation 
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
		System.out.println();
	}
}
