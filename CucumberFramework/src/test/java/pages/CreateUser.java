package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generics.ExcelUtile;
import generics.webdriverutile;

public class CreateUser {

	WebDriver driver;
	webdriverutile WebUtile = new webdriverutile(driver);

	public CreateUser(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Create User')]")
	private WebElement HeaderCreateUser;

	@FindBy(id = "firstName")
	private WebElement Enterfirstname;

	@FindBy(id = "lastName")
	private WebElement Enterlastname;

	@FindBy(id = "email")
	private WebElement EnterEmail;

	@FindBy(xpath = "//ng-select[@placeholder='Select Country']")
	private WebElement countrycodedd;

	/*
	 * @FindBy(xpath = "//span[contains(text(),'(+91)')]") private WebElement
	 * countrycodeIndia;
	 * 
	 * @FindBy(xpath = "//span[contains(text(),'(+971)')]") private WebElement
	 * countrycodeUAE;
	 * 
	 * @FindBy(xpath = "//span[contains(text(),'(+86)')]") private WebElement
	 * countrycodeChina;
	 */

	@FindBy(id = "phoneNumber")
	private WebElement Phonenumber;

	@FindBy(xpath = "//div[@class='ng-select-container ng-has-value']")
	private WebElement roledd;

	@FindBy(xpath = "//span[contains(text(),'SuperAdmin')]")
	private WebElement RoleSuperAdmin;

	@FindBy(xpath = "//span[contains(text(),'Admin') and @class='ng-value-label']")
	private WebElement RoleAdmin;

	@FindBy(xpath = "//div[@class='ng-select-container']//div[@class='ng-value-container']//div[text()='Select...']")
	private WebElement projectdd;

	@FindBy(xpath = "//label[@class='switch-pane']//span[contains(text(),'Active')]")
	private WebElement Activetoggle;

	@FindBy(xpath = "//label[@class='switch-pane']//span[contains(text(),'Inactive')]")
	private WebElement Inactivetoggle;

	@FindBy(xpath = "//label[@class='switch-pane']//span[contains(text(),'Yes')]")
	private WebElement LockYes;

	@FindBy(xpath = "//label[@class='switch-pane']//span[contains(text(),'No')]")
	private WebElement LockNo;

	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(),'Save')]")
	private WebElement Savebtn;

	@FindBy(xpath = "//button[@class='btn btn-outline-primary' and contains(text(),'Cancel')]")
	private WebElement Cancelbtn;

	public void Enter_user_details(String firstname, String lastname, String email, String phonenumber) {
		Enterfirstname.sendKeys(firstname);
		Enterlastname.sendKeys(lastname);
		EnterEmail.sendKeys(email);
		countrycodedd.click();
		// countrycodeIndia.click();
		Phonenumber.sendKeys(phonenumber);
		roledd.click();
		RoleSuperAdmin.click();
		RoleAdmin.click();

	}

	
}
