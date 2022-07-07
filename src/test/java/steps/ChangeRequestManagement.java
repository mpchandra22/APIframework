package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;
import java.util.Map.Entry;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ChangeRequestManagement extends Common	{

	@When("new change request is created")
	public void a_new_change_request_created(){
		response = request.when().contentType(ContentType.JSON).post("change_request");
		response.prettyPrint();
	}
	
	@When("get all change request")
	public void get_all_change_requests(){
		response = request.when().contentType(ContentType.JSON).get("change_request");
		response.prettyPrint();
	}

}


