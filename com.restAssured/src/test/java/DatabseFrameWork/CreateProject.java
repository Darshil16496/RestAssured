package DatabseFrameWork;
import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.annotations.Test;

import CreatePojoclass.CreatePojoClass;
import genericUtility.BaseClass;
import genericUtility.EndPointsLibrary;
import io.restassured.response.Response;
import junit.framework.Assert;

public class CreateProject extends BaseClass{
@Test
	public void createProject() throws SQLException {
		CreatePojoClass cp = new CreatePojoClass("Ajay", "TYSS"+jlib.getRandomNum(), "On going", 10);
		
		Response resp = given().spec(req)
				.body(cp)
				.when()
				.post(EndPointsLibrary.createProject);
		//step3 : capture theProject ID
		String expData = rlib.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		String query = "select * from project";
		String actData = dlib.executeQueryAndGetData(query, expData, 1);
		Assert.assertEquals(expData, actData);
		System.out.println("Tc Pass");
		
		resp.then().log().all();
	}
	
	
}
