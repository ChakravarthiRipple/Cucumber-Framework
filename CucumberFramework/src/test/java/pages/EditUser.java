package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUser {

	WebDriver driver;

	public EditUser(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "vertical-menu-btn")
	private WebElement Hamburgericon;

	@FindBy(xpath = "//a[@class='side-nav-link-ref active']")
	private WebElement consumericon;

	@FindBy(xpath = "//a[contains(text(),'Users')]")
	private WebElement usersheadtext;

	@FindBy(xpath = "//button[contains(text(),'Create User ')]")
	private WebElement CreateBtn;

	@FindBy(xpath = "(//tbody[@class='k-table-tbody']//tr//td[@class='k-table-td k-touch-action-auto'])[7]")
	private WebElement Togglebtn;

	@FindBy(id = "k-02a5d795-224e-4b52-90ae-9725b3f403b2")
	private WebElement Searchfield;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-md border-left-none']")
	private WebElement Serachbtn;

	@FindBy(xpath = "(//tbody[@class='k-table-tbody']//tr//td)[9]//i[@class='fas fa-edit text-primary']")
	private WebElement EditIcon;

	@FindBy(xpath = "(//tbody[@class='k-table-tbody']//tr//td)[9]//i[@class='fas fa-trash-alt text-danger']")
	private WebElement DeleteIcon;

	public void EnterPassword(String password) {

		consumericon.sendKeys(password);
	}
}
