package PathParam;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PathParameterClass {

		@Test
		public void pathparam() {
			
			baseURI = "http://rmgtestingserver";
			port = 8084;
			
			given().pathParam("proid", "TY_PROJ_75876")
			
			//Get the Single Product
			.when().get("/projects/{proid}")
			
			.then()
			.assertThat()
			.statusCode(200).contentType(ContentType.JSON).log();
			
			
		}
}
