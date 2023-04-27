package week4Assign4Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features="src/test/java/week4Assign4Features/CreateIncident.feature",
	   		glue={"week4Assign4Steps"},
			monochrome = true			
			)

	public class CreateIncidentRunner extends AbstractTestNGCucumberTests{

	}

