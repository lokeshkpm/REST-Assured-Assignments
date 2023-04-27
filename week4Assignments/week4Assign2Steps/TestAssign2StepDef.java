package week4Assign2Steps;

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

public class TestAssign2StepDef {

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

	@When("send the request")
	public void sendRequest() {
		request = RestAssured.given().log().all();
		response = request.get();
	}

	@Then("validate the response")
	public void validateResponse() {
		response.then().log().all().assertThat().statusCode(200);
	}

	@And("add the queryParams as {string} and {string}")
	public void setQueryParams(String key, String Value) {
		request = RestAssured.given().log().all().queryParam(key, Value).contentType(ContentType.JSON);

	}
	
	@When("send the post request")
	public void sendRequestPost() {
		response = RestAssured.given().contentType(ContentType.JSON).post();
	}

	@When("send the request with QP")
	public void sendRequestwithQP() {
		response = request.get();
	}

	@And("add the queryParams")
	public void addqueryParams(DataTable dt) {
		Map<String, String> map_values = dt.asMap();
		request = RestAssured.given().log().all().queryParams(map_values);

	}

	@Then("validate the response for below")
	public void validateResposeStringForMulti(DataTable dt) {
		Map<String, String> asMap = dt.asMap();
		for (Entry<String, String> eachEntry : asMap.entrySet()) {

			response.then().body(eachEntry.getKey(), Matchers.equalTo(eachEntry.getValue()));
			
			

		}

	}

	@Then("validate the response as {int}")
	public void validateResposeInt(int code) {
		response.then().log().all().assertThat().statusCode(code);
	}
	
	@When("post the request with short description as {string} and category as {string}")
	public void postRequest(String short_desc, String category) {
		response = request.body("{\"short_description\":\"" + short_desc + "\",\"category\":\"" + category + "\"}")
				.post();
	
	
		
	}

}
