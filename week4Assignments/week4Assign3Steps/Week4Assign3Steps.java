package week4Assign3Steps;

import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Matchers;
import org.apache.commons.lang3.RandomStringUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Week4Assign3Steps {

	RequestSpecification request = null;
	Response response = null;
	public static String randomStr = null;
	public static String sys_id = null;

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
				request = RestAssured.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\":\"" + short_desc + "\",\"category\":\"" + category + "\"}");
		response = request.post();
		sys_id =response.jsonPath().get("result.sys_id");
	}	
	
	
	@And("update the description with randomString")
	public void updateDescwithrandomStr(){			
			randomStr = RandomStringUtils.randomAlphanumeric(6);
			request = RestAssured.given().contentType(ContentType.JSON)
			.body("{\"short_description\":\"" + randomStr + "\"}");
			response = request.put("/"+sys_id);
	}
	
	
	@Then("validate the response for description is updated")
	public void validateUpdateResponse()
	{
		response.then().assertThat().statusCode(200).log().all();
		response.then().assertThat().body("result.short_description",Matchers.matchesPattern("^[a-zA-Z0-9]{6}$"));		
		
	}
	
	@When("get the incident for delete")
	public void getIncident() {
		request = RestAssured.given().log().all();
		response = request.get();
	}
	
	@Then("send the request for delete")
	public void requestForDelete()
	{
		//sys_id =response.jsonPath().get("result.sys_id");
		//System.out.println("SYS_ID==> "+sys_id);
		response = request.delete("/"+sys_id);			
	}
	
	@And("validate the record is removed")
	public void validateRecordRemoved()
	{
		response = request.get("/"+sys_id);
		response.then().assertThat().statusCode(404).log().all();
		response.then().assertThat().body("error.message",Matchers.containsStringIgnoringCase("No Record found"));
		//response.then().assertThat().body("",Matchers.emptyOrNullString());
	}
	
	@Then("validate the response for task_effective_number")
	public void validate_task_effective_number()
	{
		response.then().assertThat().statusCode(201).log().all();
		response.then().assertThat().body("result.task_effective_number",Matchers.hasLength(10));
		
		
	}

}
