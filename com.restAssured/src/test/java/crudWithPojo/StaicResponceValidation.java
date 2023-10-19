package crudWithPojo;

import org.junit.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class StaicResponceValidation {
@Test
public void staticResponce() {
	 String expData = "TY_PROJ_17648";
	  baseURI = "http://rmgtestingserver";
	  port = 8084;
	  
	  Response res = when()
			 .get("/projects");
	  
	  String actData = res.jsonPath().get("[0].projectId");
	  Assert.assertEquals(actData, expData);
	  System.out.println("Data Verified");
	  
	  res.then().log().all();
}


}