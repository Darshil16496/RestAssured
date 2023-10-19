package crudWithoutRmgBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetProject {

	@Test
	public void getProj() {
		Response res = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_75300");
		res.then().log().all();
		int statusCode = res.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
}
