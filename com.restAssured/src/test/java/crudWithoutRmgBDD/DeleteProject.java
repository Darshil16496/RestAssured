package crudWithoutRmgBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteProject {
	@Test
	public void deleteProj() {
		Response res = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_75253");
		res.then().log().all();
		int statusCode = res.getStatusCode();
		Assert.assertEquals(204, statusCode);
	}
}
