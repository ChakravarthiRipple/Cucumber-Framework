
package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("disable-notifications");
		Options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(Options);
		driver.manage().window().maximize();

	}

	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		driver.get("https://nice-bush-09f0b7600.5.azurestaticapps.net/auth/login?returnUrl=%2Fdashboard");
		System.out.println("User in login page");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Ripple", title);

	}
	// Reg Exp:
	// 1. \"([^\"]*)\"
	// 2. \"(.*)\"

	@When("^user enters \"(.*)\" and \"(.*)\"$")
	public void the_user_enters_valid_username_and_password(String username, String password)
			throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		System.out.println("Entered valid username and password");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement LoginButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		LoginButton.click();
		System.out.println("Clicked on login button");
	}

	@Then("^user is redirected to the Super Admin Dashboard$")
	public void Super_Admin_Dashboard_Validation() throws InterruptedException {
		Thread.sleep(10000);
		String SuperAdminLogin = driver.getCurrentUrl();
		System.out.println(SuperAdminLogin);
		Assert.assertEquals(urlSAdminDash, SuperAdminLogin);

	}

	@Then("^an error message Invalid Password is displayed$")
	public void Invalid_password() throws InterruptedException {
		Thread.sleep(3000);
		String ErrorMessage = driver.findElement(By.xpath("//h2[contains(text(),'Invalid Password')]")).getText();
		System.out.println(ErrorMessage);
		Assert.assertEquals("Invalid Password", ErrorMessage);
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		String ErrorMessageLoginpage = driver.findElement(By.xpath("//div[contains(text(),'Invalid Password')]"))
				.getText();
		System.out.println(ErrorMessageLoginpage);
		Assert.assertEquals("Invalid Password", ErrorMessageLoginpage);
	}

	@And("^user is still on the Login Page$")
	public void Refresh_Login_page() {
		driver.navigate().refresh();
	}

	@Then("^an error message Invalid Email/Mobile Number is displayed$")
	public void Invalid_Username() throws InterruptedException {
		Thread.sleep(3000);
		String ErrorMessage = driver.findElement(By.xpath("//h2[contains(text(),'Invalid Email/Mobile Number')]"))
				.getText();
		System.out.println(ErrorMessage);
		Assert.assertEquals("Invalid Email/Mobile Number", ErrorMessage);
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		String ErrorMessageLoginpage = driver
				.findElement(By.xpath("//div[contains(text(),' Invalid Email/Mobile Number ')]")).getText();
		System.out.println(ErrorMessageLoginpage);
		Assert.assertEquals("Invalid Email/Mobile Number", ErrorMessageLoginpage);

	}

	@When("^the user leaves blank fileds and clicks on the Login button$")
	public void user_clicks_on_login_button_without_Filling_Username_and_password() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("^an error message Email / Mobile Number is required is displayed$")
	public void validate_Login_Username_Error_Messages() throws InterruptedException {
		Thread.sleep(3000);

		String EmailRequire = driver
				.findElement(By.xpath("//div[contains(text(),'Email / Mobile Number is required')]")).getText();

		Assert.assertEquals("Email / Mobile Number is required", EmailRequire);

	}

	@Then("^an error message Password is required is displayed$")
	public void validate_Login_Password_Error_Messages() throws InterruptedException {
		Thread.sleep(3000);
		String passwordRequire = driver.findElement(By.xpath("//span[contains(text(),'Password is required')]"))
				.getText();
		Assert.assertEquals("Password is required", passwordRequire);
		driver.navigate().refresh();

	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
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
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logout = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(@class,'dropdown-item text-danger')]")));
		logout.click();
		Thread.sleep(3000);
	}

}