package week3.day2.assignments.chain.servicenow;

import org.testng.annotations.Test;

public class DeleteIncident extends BaseClassImpl{
	
	@Test(dependsOnMethods = { "week3.day2.assignments.chain.servicenow.EditIncident.editIncidentTest"})
	public void deleteIncidentTest() {
		
		response = request.delete("incident/"+sys_id);
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(204);
	}

}
