
package StepDefination;

import org.openqa.selenium.WebDriver;
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
import pages.Loginpage;
import pages.LogoutFunctionality;

import java.io.IOException;

public class LoginSteps {

	String urlSAdminDash = "https://nice-bush-09f0b7600.5.azurestaticapps.net/dashboard";
	String urlAdminDash = "https://nice-bush-09f0b7600.5.azurestaticapps.net/admindashboard";
	String urlConsumerDash = "https://nice-bush-09f0b7600.5.azurestaticapps.net/consumerdashboard";

	String apiKey = "rLNhjagw46K8KoXy9nQkTwFtWgDof02k";
	String serverId = "jw2rdthr";
	String serverDomain = "jw2rdthr.mailosaur.net";
	String from = "support@ripplemetering.com";
	String Email = "muscle-make@jw2rdthr.mailosaur.net";

	private WebDriver driver;
	Loginpage login = new Loginpage(driver);
	LogoutFunctionality logout = new LogoutFunctionality(driver);

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
	public void the_user_enters_valid_username_and_password(String username, String password) {
		login.login(username, password);
		login.loginButton();
		System.out.println("System logged in successfully.");
	}

	@Then("^an error message Invalid Password is displayed$")
	public void Invalid_password() throws InterruptedException {
		Thread.sleep(3000);
		login.InvalidpasswordErrorHandle();
		login.OKButtonpopup();
		login.UIpasswordError();
	}

	@And("^user is still on the Login Page$")
	public void Refresh_Login_page() {
		driver.navigate().refresh();
	}

	@Then("^an error message Invalid Email/Mobile Number is displayed$")
	public void Invalid_Username() throws InterruptedException {
		Thread.sleep(3000);
		login.InvalidEmailMobileHandle();
		login.OKButtonpopup();
		login.UIEmailMobileError();
	}

	@When("^the user leaves blank fileds and clicks on the Login button$")
	public void user_clicks_on_login_button_without_Username_and_password() throws InterruptedException {
		Thread.sleep(3000);
		login.loginButton();
	}

	@Then("^an error message Email / Mobile Number is required is displayed$")
	public void validate_Login_Username_Error_Messages() throws InterruptedException {
		Thread.sleep(3000);
		login.UILoginUserfieldsError();
	}

	@Then("^an error message Password is required is displayed$")
	public void validate_Login_Password_Error_Messages() throws InterruptedException {
		Thread.sleep(3000);
		login.UILoginPassfieldsError();
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

	@Then("^user is redirected to the Super Admin Dashboard$")
	public void Super_Admin_Dashboard_Validation() throws InterruptedException {
		Thread.sleep(10000);
		String SuperAdminLogin = driver.getCurrentUrl();
		System.out.println(SuperAdminLogin);
		Assert.assertEquals(urlSAdminDash, SuperAdminLogin);

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
		logout.LogoutFunction();
	}

	@When("^user enter Email/Mobile and Click on Send button$")
	public void Enter_Details_and_Clickon_login_button() throws InterruptedException {
		login.EnterUsetname(Email);
		Thread.sleep(2000);
		login.Send_OTP_Email_Mobile();
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
		login.Enter_OTP(OTP);
		login.loginButton();

	}

	@When("^Login Valid Email ID With Invalid OTP$")
	public void Unsuccessful_login_Email_ID_with_Inavlid_OTP_requirest()
			throws InterruptedException, IOException, MailosaurException {
		Thread.sleep(5000);
		login.Enter_OTP("225566");
		Thread.sleep(1000);
		login.loginButton();
		Thread.sleep(3000);
		login.Invalid_OTP_Validation();
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
		login.Enter_OTP(OTP);
		Thread.sleep(2000);
		login.loginButton();
		login.OTP_Expired_Validation();
	}

}
