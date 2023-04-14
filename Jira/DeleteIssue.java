package week3.day2.assignments.chain.Jira;

import org.testng.annotations.Test;

public class DeleteIssue extends JiraBaseClassImpl{
	
	@Test(dependsOnMethods = { "week3.day2.assignments.chain.Jira.EditIssue.editIssueTest"})
	public void deleteIssueTest() {
		
		response = request.delete(issue_id);
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(204);
	}

}
