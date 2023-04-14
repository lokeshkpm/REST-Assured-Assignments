package week3.day2.assignments;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AssigmentAPutPatchDelete {

	@Test
	public void put() {
		RestAssured.baseURI = "https://dev78818.service-now.com/api/now/table/change_request/aa0ad55147810200e90d87e8dee490e1";

		RestAssured.authentication = RestAssured.basic("admin", "rbw+!aZGT5Q0");

		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n" + "    \"short_description\":\"using put method for hamcrest\"\r\n" + "    \r\n" + "}");

		Response response = inputRequest.put();

	    //response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}
	
	@Test
	public void patch() {
		RestAssured.baseURI = "https://dev78818.service-now.com/api/now/table/change_request/aa0ad55147810200e90d87e8dee490e1";

		RestAssured.authentication = RestAssured.basic("admin", "rbw+!aZGT5Q0");

		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n" + "    \"short_description\":\"using patch method for hamcrest\"\r\n" + "    \r\n" + "}");

		Response response = inputRequest.patch();
		response.then().assertThat().body("result.short_description", Matchers.containsString("hamcrest"));
		response.then().assertThat().body("result.number", Matchers.equalTo("CHG0000021"));
		//response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}
	
	@Test
	public void delete() {
		RestAssured.baseURI = "https://dev78818.service-now.com/api/now/table/change_request/aa0ad55147810200e90d87e8dee490e1";

		RestAssured.authentication = RestAssured.basic("admin", "rbw+!aZGT5Q0");

		RequestSpecification inputRequest = RestAssured.given();
		Response response = inputRequest.delete();

		//response.prettyPrint();
		response.then().assertThat().statusLine("HTTP/1.1 204 No Content").statusCode(204);
	}	

}
