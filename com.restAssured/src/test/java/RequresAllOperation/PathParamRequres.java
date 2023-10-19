package RequresAllOperation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class PathParamRequres {

	public void pathparam() {

		baseURI = "https://reqres.in";
		//port = 8084;

		given().pathParam("proid", "3")
		// Get the Single Product
		.when()
		.get("/api/users/{proid}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();

	}

}
