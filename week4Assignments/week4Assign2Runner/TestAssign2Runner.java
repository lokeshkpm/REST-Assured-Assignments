package week4Assign2Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		// Assignment 2b	
		//features = {"src/test/java/week4Assign2Features/getIncidentswithQP1.feature", "src/test/java/week4Assign2Features/getIncidentswithQP2.feature"} 
    	
		// Assignment 2c	
		features = "src/test/java/week4Assign2Features" 
		,glue = {"week4Assign2Steps"}
		,monochrome = true
				
				
		// Assignment 2a			
		,tags = "@Smoke"
		)

	public class TestAssign2Runner extends AbstractTestNGCucumberTests{

	}

