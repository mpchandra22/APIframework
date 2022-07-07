package services;

import java.io.File;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class ChangeRequestTests extends BaseRequest{
	
	
	//@Test
	public void getCR(){
		request
			.get("change_request")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id"))
			.extract().response()
			.prettyPrint();		
	}
	
	@Test
	public void createCR(){
		request
//			.body(new File("./data/incident1.json"))
			.post("change_request")
			.then()
			.assertThat()
			.statusCode(201)
			.body(containsString("number"),containsString("sys_id"));		
	}
}
