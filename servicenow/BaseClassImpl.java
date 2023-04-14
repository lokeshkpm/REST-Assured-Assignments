package week3.day2.assignments.chain.servicenow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClassImpl {
	
	 static RequestSpecification request=null;
	 static String sys_id=null;
	 static Response response=null;
	
	@BeforeMethod
	public void setup() {
		
		RestAssured.baseURI = "https://dev78818.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "rbw+!aZGT5Q0");
		
		request = RestAssured.given().contentType(ContentType.JSON).log().all();

	}
	
	@AfterMethod
	public void tearDown() {
		response.then().log().all();
	}

}
