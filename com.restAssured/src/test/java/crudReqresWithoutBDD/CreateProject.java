package crudReqresWithoutBDD;

import org.json.simple.JSONObject; 

import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CreateProject {
	@Test
	public void createProj() {
		JavaUtility jlib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Kuru"+jlib.getRandomNum());
		jobj.put("job", "leader");
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jobj);
		reqs.contentType(ContentType.JSON);
		Response res = reqs.post("https://reqres.in/api/users");
		System.out.println(res.prettyPeek());
		int statusCode = res.getStatusCode();
		Assert.assertEquals(201, statusCode);
	
	}
}
