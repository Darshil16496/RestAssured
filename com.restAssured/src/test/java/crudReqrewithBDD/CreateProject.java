package crudReqrewithBDD;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProject {
@Test
	public void createProj() {
	
	baseURI = "https://reqres.in/";
	//port = 8084;
	JavaUtility jlib = new JavaUtility();
	JSONObject jobj = new JSONObject();
	jobj.put("name", "Kuru"+jlib.getRandomNum());
	jobj.put("job", "leader");
	
	//Step :- PreConditions
	given()
	.body(jobj)
	.contentType(ContentType.JSON)
	
	//Step2 Actions
	.when()
	.post("/api/users")
	
	//step 3 Validation
	.then()
	.assertThat()
	.statusCode(201)
	.contentType(ContentType.JSON)
	.log()
	.all();
	
	
	
	}
}
