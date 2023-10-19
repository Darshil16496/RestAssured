package crudReqrewithBDD;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.given;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class responseBodyUsingRestAssured {

	public static void main(String[] args) {
		baseURI = "https://reqres.in/";
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Darshil4");
		jobj.put("job", "askbdsakdjsa");
		Response res = given().body(jobj).contentType(ContentType.JSON)
		.when().post("/api/users");
		res.then().assertThat().statusCode(201).log().all();
		String responseBody = res.getBody().asString();
		try {

			FileWriter file = new FileWriter("./src/test/resources/targetFile1.json");
			file.write(responseBody);
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
