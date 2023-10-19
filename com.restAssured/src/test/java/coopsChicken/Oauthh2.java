package coopsChicken;
import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import io.restassured.response.Response;
public class Oauthh2 {
	@Test
	public void oauthh2() 
	{
		Response resp = given()
		.formParam("client_id", "Darshil")
		.formParam("client_secret", "c13b98007d6bc5a0a534a1824bee9095")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://darshilprajapati.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		resp.then().log().all();
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 4677)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
		
		.then().log().all();
	}
}
