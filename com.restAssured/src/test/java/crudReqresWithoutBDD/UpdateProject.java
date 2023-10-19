package crudReqresWithoutBDD;

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
	
		JavaUtility jlib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Kuru42");
		jobj.put("job", "leader4");
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jobj);
		reqs.contentType(ContentType.JSON);
		Response res = reqs.post("https://reqres.in/api/user");
		System.out.println(res.prettyPeek());
		int statusCode = res.getStatusCode();
		Assert.assertEquals(201, statusCode);
	}
}

