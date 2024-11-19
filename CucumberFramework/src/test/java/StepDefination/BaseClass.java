package StepDefination;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import generics.webdriverutile;

public class BaseClass {

	public WebDriver driver;

	String Browser = null;
	String url = null;

	public void setUp() {
		System.out.println("Connect to DB");
	}

	public void BrowserLunchandGetUrl() throws IOException {

		System.out.println(Browser);
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();

		}
		driver.get(url);
		webdriverutile Methods = new webdriverutile(driver);
		Methods.MaxiniseWindow();

	}

	public void LoginintoApp() throws IOException {

	}

	public void LogoutApp() throws InterruptedException {

	}

	public void CloseBrowser() {
		driver.close();
	}

	public void disconnectfromDB() {
		System.out.println("disconnect");
	}

}