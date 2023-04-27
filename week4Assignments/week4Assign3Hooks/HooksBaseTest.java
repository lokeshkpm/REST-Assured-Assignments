package week4Assign3Hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class HooksBaseTest {
	
	@Before
	public void setup() {
		RestAssured.baseURI = "https://dev71749.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Y-9Ph^3NjZqg");
	}

}
