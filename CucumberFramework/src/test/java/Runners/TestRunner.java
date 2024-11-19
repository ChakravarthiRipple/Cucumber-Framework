package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"./src/test/resources/Features/SuperAdminlogin.feature","./src/test/resources/Features/AdminLogin.feature","./src/test/resources/Features/ConsumerLogin.feature"},
		//tags = "@smoketest",
		glue = {"StepDefination","LoginSteps"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports.html"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}


 