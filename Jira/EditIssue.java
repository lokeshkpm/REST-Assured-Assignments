package week3.day2.assignments.chain.Jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EditIssue extends JiraBaseClassImpl{
	
	@Test(dependsOnMethods = { "week3.day2.assignments.chain.Jira.CreateIssue.createIssueTest"})
	public void editIssueTest() {
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"fields\": {\r\n"
						+ "\r\n"
						+ "        \"description\": \"Editing issue\"\r\n"
						+ "    }\r\n"
						+ "}\r\n"
						+ ")");
		response = request.put(issue_id);		
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(204);
	}

}
