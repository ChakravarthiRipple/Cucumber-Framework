package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"./src/test/resources/Features/SuperAdminlogin.feature"},
		glue = {"StepDefination"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","json:target/cucumber.json"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}


 