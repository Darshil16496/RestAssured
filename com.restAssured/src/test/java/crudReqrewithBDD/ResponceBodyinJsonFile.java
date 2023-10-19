package crudReqrewithBDD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ResponceBodyinJsonFile {

	public static void main(String[] args) {
	
		String jsonString = "{\"name\" : \"kanak\",\"password\" : \"kanak123\"}";
 		RequestSpecification request= RestAssured.given();
 		request.contentType(ContentType.JSON);
 		request.baseUri("https://reqres.in/api/users");
 		request.body(jsonString);
 		Response response = request.post();
 		System.out.println(response.asString());
 		try {
 			PrintStream out = new PrintStream(new File("src/main/resources/targetFile.json"));
 			System.setOut(out);
 		}
 		catch(FileNotFoundException fx) 
 		{
 			System.out.println(fx);
 		}
 		ValidatableResponse validatableResponse = response.then();   
 		validatableResponse.statusCode(201);
 		System.out.println(response.getStatusCode());
 		System.out.println(response.jsonPath().get("id"));
 		System.out.println(response.jsonPath().get("name"));
 		System.out.println(response.jsonPath().get("password"));
 		
 		
 	}
	

}
