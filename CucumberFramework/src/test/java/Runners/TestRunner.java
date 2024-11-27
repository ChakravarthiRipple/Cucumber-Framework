package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"./src/test/resources/Features/SuperAdminlogin.feature","./src/test/resources/Features/AdminLogin.feature","./src/test/resources/Features/ConsumerLogin.feature"},
		glue = {"StepDefination"},
		dryRun = true,
		monochrome = true,
		plugin = {"pretty","json:target/cucumber.json"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}


 