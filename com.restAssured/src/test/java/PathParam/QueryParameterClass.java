package PathParam;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class QueryParameterClass {
	
	@Test
	public void QueryParamae() {
		baseURI = "https://reqres.in";
	//	port = 8084;
		
		given().queryParam("page", 2)
		
		//Get the Single Product
		.when().get("/api/users")
		
		.then()
		.assertThat()
		.statusCode(200).contentType(ContentType.JSON).log().all();
	}
}
