package week4Assign3Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features="src/test/java/week4Assign3Features/Incidents.feature",
	   		glue={"week4Assign3Steps", "week4Assign3Hooks"},
			monochrome = true			
			)

	public class TestAssign3Runner extends AbstractTestNGCucumberTests{

	}

