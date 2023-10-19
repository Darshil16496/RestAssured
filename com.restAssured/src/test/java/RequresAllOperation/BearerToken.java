package RequresAllOperation;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class BearerToken {
	
	@Test
	public void bearertoken() {
		baseURI = "https://api.github.com";
		JSONObject js = new JSONObject();
		js.put("name", "RestAssuredDarsh");
		
		given()
		.auth()
		.oauth2("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")
		.body(js)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().log().all();
	}
}
