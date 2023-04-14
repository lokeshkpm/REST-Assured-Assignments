package week3.day2.assignments.chain.servicenow;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EditIncident extends BaseClassImpl{
	
	@Test(dependsOnMethods = { "week3.day2.assignments.chain.servicenow.CreateIncident.createIncidentTest"})
	public void editIncidentTest() {
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "  \"description\": \"Editing Incident\"\r\n"
						+ "}");
		response = request.put("incident/"+sys_id);
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(200);
	}

}
