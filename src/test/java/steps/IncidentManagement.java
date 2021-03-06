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

public class IncidentManagement extends Common{
	
	@Given("enable logs")
	public void setUp(){ 
		request = given().log().all();
	}
	
	@When("short description is added with (.*)$")
	public void add_short_description(String short_desc){
		request = request.when().body("{\"short_description\" : \""+short_desc+"\"}");
	}
	
	@When("description is added with (.*)$")
	public void add_description(String desc){
		request = request.when().body("{\"description\" : \""+desc+"\"}");
	}

	@When("new incident is created")
	public void a_new_incident_created(){
		response = request.when().contentType(ContentType.JSON).post("incident");
		response.prettyPrint();
	}
	
	@When("get all incidents")
	public void get_all_incidents(){
		response = request.when().contentType(ContentType.JSON).get("incident");
		response.prettyPrint();
	}
	//    \\d -> Only digit
	// 		+ -> 1 or more digit
	@Then("the status code is (\\d+)$")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	}

	@And("response includes the following$")
	public void response_equals(Map<String,String> responseFields){
									//temp <= (Each EntrySet)
		for (Map.Entry<String, String> field : responseFields.entrySet()) { //EntrySet  => Key -> Value 
			if(StringUtils.isNumeric(field.getValue())){
//				json.body("result.sys_created_by", equalTo(-4));
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			}
			else{
//				json.body("result.sys_created_by", equalTo("admin"));
				json.body(field.getKey(), equalTo(field.getValue()));
			}
			
		}
	}

	@And("response includes the following in any order$")
	public void response_contains_in_any_order(Map<String,String> responseFields){
			
		//Foreach to read each map value
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), containsInAnyOrder(field.getValue()));
			}
		
		}
	}
}


