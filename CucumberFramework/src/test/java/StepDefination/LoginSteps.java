
package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Code;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.time.Duration;

public class LoginSteps {

	WebDriverWait wait;
	String urlSAdminDash = "https://nice-bush-09f0b7600.5.azurestaticapps.net/dashboard";
	String urlAdminDash = "https://nice-bush-09f0b7600.5.azurestaticapps.net/admindashboard";
	String urlConsumerDash = "https://nice-bush-09f0b7600.5.azurestaticapps.net/consumerdashboard";
	String apiKey = "rLNhjagw46K8KoXy9nQkTwFtWgDof02k";
	String serverId = "jw2rdthr";
	String serverDomain = "jw2rdthr.mailosaur.net";
	String from = "support@ripplemetering.com";
	String Email = "muscle-make@jw2rdthr.mailosaur.net";

	private WebDriver driver;

	public LoginSteps() {

		this.driver = Hooks.getDriver();
	}

	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		driver.get("https://nice-bush-09f0b7600.5.azurestaticapps.net/auth/login?returnUrl=%2Fdashboard");
		System.out.println("User in login page");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Ripple", title);

	}

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
	public void user_clicks_on_login_button_without_Username_and_password() throws InterruptedException {
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

	@When("^user enter Email/Mobile and Click on Send button$")
	public void Enter_Details_and_Clickon_login_button() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("email")).sendKeys(Email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='form-check-input login-check']")).click();
		WebElement SendButton = driver.findElement(By.xpath("//button[contains(text(),' Send OTP ')]"));
		if (SendButton.isDisplayed()) {
			SendButton.click();
		} else {
			System.out.println("Click again");

		}
	}

	@When("^Login Valid Email ID With Valid OTP$")
	public void Successful_login_Email_ID_with_OTP_requirest()
			throws InterruptedException, IOException, MailosaurException {
		Thread.sleep(10000);
		MailosaurClient mailosaur = new MailosaurClient(apiKey);
		MessageSearchParams params = new MessageSearchParams();
		params.withServer(serverId);
		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo(Email);
		criteria.withSentFrom(from);
		Message message = mailosaur.messages().get(params, criteria);
		System.out.println(message.html().codes().size());
		Code firstCode = message.html().codes().get(0);
		System.out.println(firstCode.value());
		String OTP = firstCode.value();
		WebElement EnterOTP = driver.findElement(By.xpath("//input[contains(@class,'form-control ng-un')]"));
		EnterOTP.sendKeys(OTP);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();

	}

	@When("^Login Valid Email ID With Invalid OTP$")
	public void Unsuccessful_login_Email_ID_with_Inavlid_OTP_requirest()
			throws InterruptedException, IOException, MailosaurException {
		Thread.sleep(5000);
		WebElement EnterOTP = driver.findElement(By.xpath("//input[contains(@class,'form-control ng-un')]"));
		EnterOTP.sendKeys("225566");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
		Thread.sleep(3000);
		String Invalid = driver.findElement(By.xpath("//h2[contains(text(),'Invalid OTP')]")).getText();
		System.out.println(Invalid);
		Assert.assertEquals("Invalid OTP", Invalid);
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		String InvalidLoginpage = driver.findElement(By.xpath("//div[contains(text(),' Invalid OTP ')]")).getText();
		Assert.assertEquals(Invalid, InvalidLoginpage);

	}

	@When("^Unsuccessful login Email ID with Expired OTP$")
	public void Unsuccessful_login_Email_ID_with_Expired_OTP()
			throws InterruptedException, IOException, MailosaurException {
		Thread.sleep(5 * 60 * 1000);
		MailosaurClient mailosaur = new MailosaurClient(apiKey);
		MessageSearchParams params = new MessageSearchParams();
		params.withServer(serverId);
		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo(Email);
		criteria.withSentFrom(from);
		Message message = mailosaur.messages().get(params, criteria);
		System.out.println(message.html().codes().size());
		Code firstCode = message.html().codes().get(0);
		System.out.println(firstCode.value());
		String OTP = firstCode.value();
		WebElement EnterOTP = driver.findElement(By.xpath("//input[contains(@class,'form-control ng-un')]"));
		EnterOTP.sendKeys(OTP);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
		String OTPExpiry = driver.findElement(By.xpath("//div[contains(text(),'OTP has expired')]")).getText();
		System.out.println(OTPExpiry);
		Assert.assertEquals("OTP has expired", OTPExpiry);
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		String OTPExpiryloginpage = driver.findElement(By.xpath("//div[contains(text(),' OTP has expired ')]"))
				.getText();
		Assert.assertEquals(OTPExpiryloginpage, OTPExpiry);
	}

}
