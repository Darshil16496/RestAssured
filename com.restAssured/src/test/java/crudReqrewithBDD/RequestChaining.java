package crudReqrewithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class RequestChaining {

	
	@Test
	public void requestChaining() {
		baseURI = "https://reqres.in/";
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Darshil4");
		jobj.put("job", "askbdsakdjsa");
		
		
			Response res = given()
					.body(jobj)
					.contentType(ContentType.JSON)
					
				.when()
				.post("/api/users");
				
				//res.then().log().all();
			
			String pid = res.jsonPath().get("id");
			System.out.println(pid);
			res.then().assertThat().statusCode(201).log().all();
			
			
			when().get("/api/users/"+pid)
			.then().log().all();
		
	}
}
