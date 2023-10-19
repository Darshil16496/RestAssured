package SerilizationDeserialization;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import CreatePojoclass.CreatePojoClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateProject {

	@Test 
	public void createPj() {
		//JavaUtility jlib = new JavaUtility();
		CreatePojoClass cp =new  CreatePojoClass("Kuresha", "tyss7","completed",10);
		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resp = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.expectStatusCode(201).build();
		given()
		.spec(req).body(cp)
		
		.when().post("/addProject")
		.then().spec(resp).log().all();
		
	}

	
	
}
