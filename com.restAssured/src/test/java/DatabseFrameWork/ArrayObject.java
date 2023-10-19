package DatabseFrameWork;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
@Test
public class ArrayObject {

	

	@Test
	public void arrayObj() {
		baseURI = "http://rmgtestingserver";
		port=8084;
		when().get("/projects/TY_PROJ_9938")
		//.then().assertThat().body("", Matchers.instanceOf(Map.class)).log().all();
		//IF we use map.class it will get failed 
		.then().assertThat().body("", Matchers.instanceOf(List.class)).log().all();
		
	}
}
