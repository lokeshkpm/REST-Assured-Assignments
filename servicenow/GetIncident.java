package week3.day2.assignments.chain.servicenow;

import org.testng.annotations.Test;

public class GetIncident extends BaseClassImpl{
	
	@Test(dependsOnMethods = { "week3.day2.assignments.chain.servicenow.CreateIncident.createIncidentTest"})
	public void getIncidentTest() {
		
		response = request.get("incident/"+sys_id);
		System.out.println(response.statusLine());
		response.then().assertThat().statusCode(200);
	}

}
