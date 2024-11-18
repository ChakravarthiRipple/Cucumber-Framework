
package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("disable-notifications");
		Options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get("https://nice-bush-09f0b7600.5.azurestaticapps.net/auth/login?returnUrl=%2Fdashboard");
	}

	@When("^title of login page is Ripple$")
	public void title_of_login_page_is_Ripple() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Ripple", title);
	}

	// Reg Exp:
	// 1. \"([^\"]*)\"
	// 2. \"(.*)\"

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^user logout from the application$")
	public void user_Logout_from_App() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Profile = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Super Admin')]")));
		Profile.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logout = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-item text-danger']")));
		logout.click();
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
