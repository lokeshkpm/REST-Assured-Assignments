package week3.day2.assignments.chain.Jira;

import org.testng.annotations.Test;

public class GetIssue extends JiraBaseClassImpl{
	
	@Test(dependsOnMethods = { "week3.day2.assignments.chain.Jira.CreateIssue.createIssueTest"})
	public void getIncidentTest() {
		
		response = request.get(issue_id);
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(200);
	}

}
