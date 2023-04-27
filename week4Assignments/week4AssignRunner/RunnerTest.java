package week4AssignRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    		features = "src/test/java/week4AssignFeatures/Incidents.feature",
    		glue = {"week4AssignSteps"},		
			monochrome = true
			)

	public class RunnerTest extends AbstractTestNGCucumberTests{

	}

