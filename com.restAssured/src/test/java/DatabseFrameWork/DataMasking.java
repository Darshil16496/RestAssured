package DatabseFrameWork;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;

public class DataMasking {
	@Test
	public void dataMasking() {
		JavaUtility jlib = new JavaUtility();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Kurush");
		jObj.put("projectName", "Darshu"+jlib.getRandomNum());
		jObj.put("status", "Completed");
		jObj.put("teamSize", 3);
		
		given()
		.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type")))
		.body(jObj)
		.contentType(ContentType.JSON)
		.log().all()
		.when().post("http://rmgtestingserver:8084/addProject")
		.then()
		.assertThat()
		.log().all();
	
		
	}
}
