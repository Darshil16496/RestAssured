package RequresAllOperation;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
public class CreateProjectWithHashmap {

	public void createProject() {
		baseURI = "https://reqres.in";
		
		//By HashMap
		HashMap<Object, Object> hm = new HashMap<Object, Object>();
		hm.put("name", "ajay");
		hm.put("job", "hello");
		
		//Step 1 :- Pre-Condition
		given()
		.body(hm)
		
		//Step 2:- Actions
		.when()
		.post("/api/user")
		
		//Step 3:- Validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
	}
}
