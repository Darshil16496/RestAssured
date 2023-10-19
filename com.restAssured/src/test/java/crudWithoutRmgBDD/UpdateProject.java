package crudWithoutRmgBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class UpdateProject {
	@Test
	public void updateProject() {
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Darshil");
		jObj.put("projectName", "Darsh125");
		jObj.put("status", "ongoing");
		jObj.put("teamSize",5);
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jObj);
		reqs.contentType(ContentType.JSON);
		Response res = reqs.put("http://rmgtestingserver:8084/projects/TY_PROJ_75300");
//		System.out.println(res.prettyPeek());
		res.then().log().all();
		int statusCode = res.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
}
