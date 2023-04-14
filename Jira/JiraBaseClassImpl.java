package week3.day2.assignments.chain.Jira;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraBaseClassImpl {
	
	 static RequestSpecification request=null;
	 static String issue_id=null;
	 static String issue_key=null;
	 static Response response=null;
	
	@BeforeMethod
	public void setup() {
		
		RestAssured.baseURI = "https://lokeshkpm88.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("lokesh.kpm@gmail.com", 
				"ATATT3xFfGF0YzVqmLJEIlzWIuUKgS_yow_kUc4CH8q1MA3_8Gs11vFM1LxQwx0WToSKwnZBY5s8yWGydOC_LaFGacIpWucFUv9gBUXIhXZ6Bwm1KD2VTT49TgTc_tIT6vjsJOJx-euqZUOu1pDnQ53JHSRJI1-gH3h-0lca79ap20FGEg7Jnl0=0C5F23A6");
		
		request = RestAssured.given().contentType(ContentType.JSON).log().all();

	}
	
	@AfterMethod
	public void tearDown() {
		response.then().log().all();
	}

}
