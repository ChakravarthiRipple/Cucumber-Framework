
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Loginpage {

	WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "email")
	private WebElement newusername;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement newpassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginbtn;

	@FindBy(xpath = "//h2[contains(text(),'Invalid Password')]")
	private WebElement InvalidPassward;

	@FindBy(xpath = "//h2[contains(text(),'Invalid Email/Mobile Number')]")
	private WebElement InvalidEmailMobile;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement OKButtonpopup;

	@FindBy(xpath = "//div[contains(text(),'Invalid Password')]")
	private WebElement loginUIErrorpassword;

	@FindBy(xpath = "//div[contains(text(),' Invalid Email/Mobile Number ')]")
	private WebElement LoginUIErrorEmailMobile;

	@FindBy(xpath = "//div[contains(text(),'Email / Mobile Number is required')]")
	private WebElement EmailRequirefiledError;

	@FindBy(xpath = "//span[contains(text(),'Password is required')]")
	private WebElement PasswordRequirefiledError;

	@FindBy(xpath = "//input[@class='form-check-input login-check']")
	private WebElement checkboxclick;

	@FindBy(xpath = "//button[contains(text(),' Send OTP ')]")
	private WebElement sendOTPbuton;

	@FindBy(xpath = "//input[contains(@class,'form-control ng-un')]")
	private WebElement EnetrOTP;

	@FindBy(xpath = "//h2[contains(text(),'Invalid OTP')]")
	private WebElement InvalidOTP;

	@FindBy(xpath = "//div[contains(text(),' Invalid OTP ')]")
	private WebElement UIloginInvalidOTP;

	@FindBy(xpath = "//div[contains(text(),'OTP has expired')]")
	private WebElement ExpiryOTPpopup;

	@FindBy(xpath = "//div[contains(text(),' OTP has expired ')]")
	private WebElement UIExpiryOTPMessage;

	public void login(String username, String password) {
		newusername.sendKeys(username);
		newpassword.sendKeys(password);
	}

	public void EnterUsetname(String username) {
		newusername.sendKeys(username);
	}

	public void loginButton() {
		loginbtn.click();
	}

	public void OKButtonpopup() {
		OKButtonpopup.click();
	}

	public void InvalidpasswordErrorHandle() {
		String ErrorMessage = InvalidPassward.getText();
		System.out.println(ErrorMessage);
		Assert.assertEquals("Invalid Password", ErrorMessage);
		OKButtonpopup.click();
	}

	public void InvalidEmailMobileHandle() {
		String ErrorMessage = InvalidEmailMobile.getText();
		System.out.println(ErrorMessage);
		Assert.assertEquals("Invalid Email/Mobile Number", ErrorMessage);
		OKButtonpopup.click();
	}

	public void UIpasswordError() {
		String ErrorMessage = loginUIErrorpassword.getText();
		System.out.println(ErrorMessage);
		Assert.assertEquals("Invalid Password", ErrorMessage);
		OKButtonpopup.click();
	}

	public void UIEmailMobileError() {
		String ErrorMessage = LoginUIErrorEmailMobile.getText();
		System.out.println(ErrorMessage);
		Assert.assertEquals("Invalid Email/Mobile Number", ErrorMessage);
		OKButtonpopup.click();
	}

	public void UILoginUserfieldsError() {
		String EmailErrorMessage = EmailRequirefiledError.getText();
		Assert.assertEquals("Email / Mobile Number is required", EmailErrorMessage);

	}

	public void UILoginPassfieldsError() {
		String PasswordErrorMessage = PasswordRequirefiledError.getText();
		Assert.assertEquals("Password is required", PasswordErrorMessage);

	}

	public void Send_OTP_Email_Mobile() {
		checkboxclick.click();
		sendOTPbuton.click();
	}

	public void Enter_OTP(String OTP) {
		EnetrOTP.sendKeys(OTP);
	}

	public void Invalid_OTP_Validation() {
		String Invalid = InvalidOTP.getText();
		System.out.println(Invalid);
		Assert.assertEquals("Invalid OTP", Invalid);
		String InvalidLoginpage = UIloginInvalidOTP.getText();
		Assert.assertEquals(Invalid, InvalidLoginpage);
	}

	public void OTP_Expired_Validation() {
		String OTPExpiry = ExpiryOTPpopup.getText();
		System.out.println(OTPExpiry);
		Assert.assertEquals("OTP has expired", OTPExpiry);
		String OTPExpiryloginpage = UIExpiryOTPMessage.getText();
		Assert.assertEquals(OTPExpiryloginpage, OTPExpiry);
	}

}