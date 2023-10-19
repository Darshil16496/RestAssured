package crudWithPojo;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import CreatePojoclass.CreatePojoClass;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChanining {

	@Test
	public void createProj() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaUtility ju = new JavaUtility();

		CreatePojoClass cp = new CreatePojoClass("Kueush", "Kuresh" + ju.getRandomNum(), "OnGoing", 8);
		// Step :- PreConditionste
		given().body(cp).contentType(ContentType.JSON)

		// Step2 Actions
		.when().post("/addProject")

//		 step 3 Validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();

		/// Request Chaining
		Response res = when().get("/projects");
		boolean flag = false;
		String pidalone = res.jsonPath().get("[0].projectId");
		List<String> pids = res.jsonPath().get("projectId");
		for (String pid : pids) {
			if (pid.equalsIgnoreCase(pidalone)) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("Data Verified");

		res.then().log();
	}
}
