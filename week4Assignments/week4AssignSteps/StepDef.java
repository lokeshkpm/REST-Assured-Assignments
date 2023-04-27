package week4AssignSteps;

import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef {

	RequestSpecification request = null;
	Response response = null;

	@Given("set the endpoint")
	public void setEndpoint() {
		RestAssured.baseURI = "https://dev71749.service-now.com/api/now/table/incident";
	}

	@And("add the auth")
	public void addAuth() {
		RestAssured.authentication = RestAssured.basic("admin", "Y-9Ph^3NjZqg");
	}

	@And("add the queryParams as {string} and {string}")
	public void setQueryParams(String key, String Value) {
		request = RestAssured.given().log().all().queryParam(key, Value).contentType(ContentType.JSON);

	}
	
	@When("post the request with short description as {string} and category as {string}")
	public void postRequest(String short_desc, String category) {
		response = request.body("{\"short_description\":\"" + short_desc + "\",\"category\":\"" + category + "\"}")
				.post();	
	}
	
	@Then("validate the response {string} and {string} and {string}")
	public void validateResposeInt(String short_desc , String category , String key) {
		
		if(key == "1") 
		  { 
			response.then().assertThat().body("result.category",		  
			Matchers.equalTo(category)); 
		  } 
		  else if(key == "2") 
		  {
		  response.then().assertThat().body("result.category",
		  Matchers.not("software,inquiry")); 
		  } 
		  else {
		  response.then().assertThat().body("result.short_description",
		  Matchers.notNullValue()); 
		  }
	}
	

}
