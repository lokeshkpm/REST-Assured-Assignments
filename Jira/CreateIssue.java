package week3.day2.assignments.chain.Jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CreateIssue extends JiraBaseClassImpl{
	@Test
		public void createIssueTest() {
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "  \"fields\": {\r\n"
						+ "    \"project\": {\r\n"
						+ "      \"key\": \"PROJ\"\r\n"
						+ "    },\r\n"
						+ "    \"summary\": \"create issue in RA project\",\r\n"
						+ "    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
						+ "    \"issuetype\": {\r\n"
						+ "      \"name\": \"Bug\"\r\n"
						+ "    }\r\n"
						+ "  }\r\n"
						+ "}");
		response = request.post();
		issue_id = response.jsonPath().get("id");
		issue_key = response.jsonPath().get("key");
		System.out.println("Issue_id== "+issue_id);
		System.out.println("Issue_Key== "+issue_key);
		response.then().assertThat().statusCode(201);
//		throw new RuntimeException();
	}

}
