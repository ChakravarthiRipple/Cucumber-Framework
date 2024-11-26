
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutFunctionality {

	WebDriver driver;

	public LogoutFunctionality(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[contains(@class,'d-none d-xl-inline-block ms-1')]")
	private WebElement Profileicon;

	@FindBy(xpath = "//a[contains(@class,'dropdown-item text-danger')]")
	private WebElement Logout;

	public WebElement Profileicon() {
		return Profileicon;
	}

	public WebElement Logout() {
		return Logout;
	}

	public void LogoutFunction() {
		Profileicon.click();
		Logout.click();

	}

}
