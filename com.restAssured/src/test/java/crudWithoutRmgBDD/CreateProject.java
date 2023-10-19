package crudWithoutRmgBDD;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class CreateProject {
	
	@Test
	public void createProj() {
		
		JavaUtility jlib = new JavaUtility();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Darshil");
		jObj.put("projectName", "Darsh"+jlib.getRandomNum());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 3);
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jObj);
		reqs.contentType(ContentType.JSON);
		Response res = reqs.post("http://rmgtestingserver:8084/addProject");
		System.out.println(res.prettyPeek());
		
}
	}