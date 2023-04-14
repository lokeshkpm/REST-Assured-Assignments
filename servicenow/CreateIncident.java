package week3.day2.assignments.chain.servicenow;


import org.testng.annotations.Test;

public class CreateIncident extends BaseClassImpl{
	
	@Test
	public void createIncidentTest() {
		response = request.post("incident");
	
		//Assert.assertEquals(true, false);
		
		sys_id = response.jsonPath().get("result.sys_id");
		System.out.println("Sys_id=== "+sys_id);
		response.then().assertThat().statusCode(201);
//		throw new RuntimeException();
	}

}
