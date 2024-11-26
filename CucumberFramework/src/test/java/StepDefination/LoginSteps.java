
package StepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Code;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import generics.FileUtile;
import generics.webdriverutile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Loginpage;
import pages.LogoutFunctionality;

import java.io.IOException;

public class LoginSteps {
	private WebDriver driver = Hooks.getDriver();
	Loginpage loginAction = new Loginpage(driver);
	LogoutFunctionality logout = new LogoutFunctionality(driver);
	webdriverutile WebUtile = new webdriverutile(driver);

	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		System.out.println("User in login page");
		String title = WebUtile.getTitle();
		System.out.println(title);
		Assert.assertEquals("Ripple", title);

	}

	@When("^user enters \"(.*)\" and \"(.*)\"$")
	public void the_user_enters_valid_username_and_password(String username, String password)
			throws InterruptedException {
		Thread.sleep(5000);
		loginAction.login(username, password);
		loginAction.loginButton();
		System.out.println("System logged in successfully.");
	}

	@Then("^an error message Invalid Password is displayed$")
	public void Invalid_password() throws InterruptedException {
		Thread.sleep(3000);
		loginAction.InvalidpasswordErrorHandle();
		loginAction.OKButtonpopup();
		loginAction.UIpasswordError();
	}

	@And("^user is still on the Login Page$")
	public void Refresh_Login_page() {
		/* WebUtile.refresh(); */
	}

	@Then("^an error message Invalid Email/Mobile Number is displayed$")
	public void Invalid_Username() throws InterruptedException {
		Thread.sleep(3000);
		loginAction.InvalidEmailMobileHandle();
		loginAction.OKButtonpopup();
		loginAction.UIEmailMobileError();
	}

	@When("^the user leaves blank fileds and clicks on the Login button$")
	public void user_clicks_on_login_button_without_Username_and_password() throws InterruptedException {
		Thread.sleep(3000);
		loginAction.loginButton();
	}

	@Then("^an error message Email / Mobile Number is required is displayed$")
	public void validate_Login_Username_Error_Messages() throws InterruptedException {
		Thread.sleep(3000);
		loginAction.UILoginUserfieldsError();
	}

	@Then("^an error message Password is required is displayed$")
	public void validate_Login_Password_Error_Messages() throws InterruptedException {
		Thread.sleep(3000);
		loginAction.UILoginPassfieldsError();
	}

	@Then("^user is redirected to the Super Admin Dashboard$")
	public void Super_Admin_Dashboard_Validation() throws InterruptedException, IOException {
		Thread.sleep(10000);
		String URL = WebUtile.getCurrentURL();
		System.out.println(URL);
		String SuperUrl = FileUtile.objforfileutil().readDatafromPropfile("urlSAdminDash");
		Assert.assertEquals(SuperUrl, URL);

	}

	@Then("^user should be redirected to the Admin dashboard$")
	public void user_should_be_redirected_to_the_Admin_dashboard() throws InterruptedException, IOException {
		Thread.sleep(10000);

		String URL = WebUtile.getCurrentURL();
		System.out.println(URL);
		String AdminUrl = FileUtile.objforfileutil().readDatafromPropfile("urlSAdminDash");
		Assert.assertEquals(AdminUrl, URL);

	}

	@Then("^user should be redirected to the Consumer dashboard$")
	public void user_should_be_redirected_to_the_Consumer_dashboard() throws InterruptedException, IOException {

		Thread.sleep(10000);
		String URL = WebUtile.getCurrentURL();
		System.out.println(URL);
		String ConsumerUrl = FileUtile.objforfileutil().readDatafromPropfile("urlSAdminDash");
		Assert.assertEquals(ConsumerUrl, URL);

	}

	@Then("^user logout from the application$")
	public void user_Logout_from_App() throws InterruptedException {
		logout.LogoutFunction();
	}

	@When("^user enter Email/Mobile and Click on Send button$")
	public void Enter_Details_and_Clickon_login_button() throws InterruptedException, IOException {
		String Email = FileUtile.objforfileutil().readDatafromPropfile("Email");
		loginAction.EnterUsetname(Email);
		Thread.sleep(2000);
		loginAction.Send_OTP_Email_Mobile();
	}

	@When("^Login Valid Email ID With Valid OTP$")
	public void Successful_login_Email_ID_with_OTP_requirest()
			throws InterruptedException, IOException, MailosaurException {
		Thread.sleep(10000);
		String apiKey = FileUtile.objforfileutil().readDatafromPropfile("apiKey");
		MailosaurClient mailosaur = new MailosaurClient(apiKey);
		MessageSearchParams params = new MessageSearchParams();
		String serverId = FileUtile.objforfileutil().readDatafromPropfile("serverId");
		params.withServer(serverId);
		SearchCriteria criteria = new SearchCriteria();
		String Email = FileUtile.objforfileutil().readDatafromPropfile("Email");
		String from = FileUtile.objforfileutil().readDatafromPropfile("from");
		criteria.withSentTo(Email);
		criteria.withSentFrom(from);
		Message message = mailosaur.messages().get(params, criteria);
		System.out.println(message.html().codes().size());
		Code firstCode = message.html().codes().get(0);
		System.out.println(firstCode.value());
		String OTP = firstCode.value();
		loginAction.Enter_OTP(OTP);
		loginAction.loginButton();

	}

	@When("^Login Valid Email ID With Invalid OTP$")
	public void Unsuccessful_login_Email_ID_with_Inavlid_OTP_requirest()
			throws InterruptedException, IOException, MailosaurException {
		Thread.sleep(5000);
		loginAction.Enter_OTP("225566");
		Thread.sleep(1000);
		loginAction.loginButton();
		Thread.sleep(3000);
		loginAction.Invalid_OTP_Validation();
	}

	@When("^Unsuccessful login Email ID with Expired OTP$")
	public void Unsuccessful_login_Email_ID_with_Expired_OTP()
			throws InterruptedException, IOException, MailosaurException {
		Thread.sleep(5 * 60 * 1000);
		String apiKey = FileUtile.objforfileutil().readDatafromPropfile("apiKey");
		MailosaurClient mailosaur = new MailosaurClient(apiKey);
		MessageSearchParams params = new MessageSearchParams();
		String serverId = FileUtile.objforfileutil().readDatafromPropfile("serverId");
		params.withServer(serverId);
		SearchCriteria criteria = new SearchCriteria();
		String Email = FileUtile.objforfileutil().readDatafromPropfile("Email");
		String from = FileUtile.objforfileutil().readDatafromPropfile("from");
		criteria.withSentTo(Email);
		criteria.withSentFrom(from);
		Message message = mailosaur.messages().get(params, criteria);
		System.out.println(message.html().codes().size());
		Code firstCode = message.html().codes().get(0);
		System.out.println(firstCode.value());
		String OTP = firstCode.value();
		loginAction.Enter_OTP(OTP);
		Thread.sleep(2000);
		loginAction.loginButton();
		loginAction.OTP_Expired_Validation();
	}

}