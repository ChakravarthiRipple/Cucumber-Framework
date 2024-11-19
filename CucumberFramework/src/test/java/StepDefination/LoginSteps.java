
package StepDefination;

import org.openqa.selenium.By;
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
	String urlSAdminDash = "https://nice-bush-09f0b7600.5.azurestaticapps.net/dashboard";
	String urlAdminDash = "https://nice-bush-09f0b7600.5.azurestaticapps.net/admindashboard";
	String urlConsumerDash = "https://nice-bush-09f0b7600.5.azurestaticapps.net/consumerdashboard";

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
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^user should be redirected to the Super Admin dashboard$")
	public void user_should_be_redirected_to_the_SuperAdmin_dashboard() throws InterruptedException {
		Thread.sleep(10000);
		String Dashboard = driver.getCurrentUrl();
		System.out.println(Dashboard);
		Assert.assertEquals(urlSAdminDash, Dashboard);
	}
	@Then("^user should be redirected to the Admin dashboard$")
	public void user_should_be_redirected_to_the_Admin_dashboard() throws InterruptedException {
		Thread.sleep(10000);
		String Dashboard = driver.getCurrentUrl();
		System.out.println(Dashboard);
		Assert.assertEquals(urlAdminDash, Dashboard);
	}
	@Then("^user should be redirected to the Consumer dashboard$")
	public void user_should_be_redirected_to_the_Consumer_dashboard() throws InterruptedException {
		Thread.sleep(10000);
		String Dashboard = driver.getCurrentUrl();
		System.out.println(Dashboard);
		Assert.assertEquals(urlConsumerDash, Dashboard);
	}

	@Then("^user logout from the application$")
	public void user_Logout_from_App() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Profile = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(@class,'d-none d-xl-inline-block ms-1')]")));
		Profile.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logout = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(@class,'dropdown-item text-danger')]")));
		logout.click();
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}