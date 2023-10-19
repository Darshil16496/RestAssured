package crudReqrewithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;





public class uploadImage {
	@Test
	public void uploadImage() {
		
		
		File testUploadFile = new File("C:\\Users\\SAFFRO TECHNOLOGIES\\Desktop\\download.png");
	     
        baseURI = "petstore.swagger.io/v2";
        JSONObject jobj = new JSONObject();
        jobj.put("id", 79);
        jobj.put("id", 7);
        jobj.put("name", "puppy");
     
      given()
                .contentType(ContentType.JSON)
                .body(jobj)
                .when()
                .post("/pet")
                ;
        
      ValidatableResponse res= given().multiPart("file", testUploadFile)
    		  .when().post("/pat/7/uploadImage")
    		  .then().assertThat().statusCode(200).log().all();
      
     
        
     
//        System.out.println(response.getStatusCode());
//        System.out.println(response.asString());
	}

}
