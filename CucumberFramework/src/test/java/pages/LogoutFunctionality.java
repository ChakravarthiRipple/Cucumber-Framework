
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutFunctionality {

	WebDriver driver;
	@FindBy(xpath = "//span[contains(@class,'d-none d-xl-inline-block ms-1')]")
	private WebElement Profileicon;

	@FindBy(xpath = "//a[contains(@class,'dropdown-item text-danger')]")
	private WebElement Logout;

	public WebElement getUsername() {
		return Profileicon;
	}

	public WebElement getPassword() {
		return Logout;
	}

	public LogoutFunctionality(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void LogoutFunction() {
		Profileicon.click();
		Logout.click();
	}

}
