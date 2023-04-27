package week4Assign4Steps;

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

public class CreateIncidentTestSteps {

	RequestSpecification request = null;
	Response response = null;
	public static String sys_id = null;

	@Given("set the endpoint")
	public void setEndpoint() {
		RestAssured.baseURI = "https://dev71749.service-now.com/api/now/table/incident";
	}

	@And("add the auth")
	public void addAuth() {
		RestAssured.authentication = RestAssured.basic("admin", "Y-9Ph^3NjZqg");
	}

	@And("add the queryParams as {string} and {string}")
	public void addQueryParams(String key, String value) {
		request = RestAssured.given().contentType(ContentType.JSON).log().all().queryParams(key,value);
		
	}
	@When("post the request as {string} and category as {string}")
	public void addBodyInPost(String short_desc , String category) {
	response = request.body("{\"short_description\":\"" + short_desc + "\",\"category\":\"" + category + "\"}").post();
	
	}
	
	@Then("validate the response for below")
	public void validateResposeStringForMulti(DataTable dt) {
		Map<String, String> asMap = dt.asMap();
		for (Entry<String, String> eachEntry : asMap.entrySet()) {
			response.then().body(eachEntry.getKey(), Matchers.containsString(eachEntry.getValue()));
		}

	}

	}
