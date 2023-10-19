package crudWithPojo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponceValidation {
	@Test
	public void staticResponce() {
		 String expData = "TY_PROJ_9210";
		  baseURI = "http://rmgtestingserver";
		  port = 8084;
		  
		  Response res = when()
				 .get("/projects");
		  boolean flag = false;
		List<String> pids = res.jsonPath().get("projectId");
		System.out.println(pids);
		for(String projectid:pids) {
			if(projectid.equalsIgnoreCase(expData)) {
				flag = true;
			}
		}
		  Assert.assertTrue(flag);
		  System.out.println("Data Verified");
		  
		  res.then().log().all();
	}
}
