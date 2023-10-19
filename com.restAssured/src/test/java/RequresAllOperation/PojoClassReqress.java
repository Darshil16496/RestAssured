package RequresAllOperation;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import CreatePojoclass.PojoClassRequres;
import io.restassured.http.ContentType;
public class PojoClassReqress {

	@Test
	public void classReqress() {
		baseURI = "https://reqres.in";
		
		PojoClassRequres cp = new PojoClassRequres("Ajay","ajay");
		//Step :- PreConditionste
		given()
		.body(cp)
		.contentType(ContentType.JSON)
		
		//Step2 Actions
		.when()
		.post("/api/user")
		
		//step 3 Validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
	}
}
