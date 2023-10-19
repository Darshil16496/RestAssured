package crudReqresWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetAllProject {

	@Test
	public void getProject() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.prettyPeek());
		int statusCode = res.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	
}
