package SerilizationDeserialization;



import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import CreatePojoclass.PojoSerialization;


public class SerializationTest {

//	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		PojoSerialization ps = new PojoSerialization("Darshil", 85112465,25);
		obj.writeValue(new File(".//darshil.json"), ps);
	}



}
