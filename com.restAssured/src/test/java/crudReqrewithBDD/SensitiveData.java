package crudReqrewithBDD;

import java.util.HashSet;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

import static io.restassured.RestAssured.*;

public class SensitiveData {

	@Test
	public void keepSensitiveData() {
		HashSet<String> headers = new HashSet();
		headers.add("X-REGION");
		headers.add("content-type");
		
		given().baseUri("petstore.swagger.io/v2")
		.headers("X-Region", "name")
		.config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers)))
		.log().all();
		when().get("/pet/7")
		.then().assertThat().statusCode(200);
		
		
	}
}
