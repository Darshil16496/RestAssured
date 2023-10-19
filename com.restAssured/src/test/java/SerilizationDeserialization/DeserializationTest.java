package SerilizationDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import CreatePojoclass.PojoSerialization;

public class DeserializationTest {
	
	@Test
	public void deserializationTest() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		
		PojoSerialization e1 = obj.readValue(new File(".//darshil.json"), PojoSerialization.class);
			
		System.out.println(e1.getName());
		System.out.println(e1.getPhoneNo());
		System.out.println(e1.getAge());
	}

}
