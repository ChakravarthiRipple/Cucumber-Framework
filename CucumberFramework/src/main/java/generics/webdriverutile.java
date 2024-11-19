package generics;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverutile {
	private static final String WebElement = null;
	WebDriver driver;

	public webdriverutile(WebDriver driver) {
		this.driver = driver;
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void MaxiniseWindow() {
		driver.manage().window().maximize();
	}

	public void ImplicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void ExplicityWait(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElement)));
	}

	public void selectvaluefromdd(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectvisibletextfromdd(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectindexvaluefromdd(WebElement element, int value) {
		Select select = new Select(element);
		select.selectByIndex(0);
	}

	public void movetoelement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void rightclick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public void clickbyoffset(int xoffset, int yoffset) {
		Actions act = new Actions(driver);
		act.moveByOffset(xoffset, yoffset).click();
	}

	public void switchtoframe(int index) {
		driver.switchTo().frame(index);
	}

	public void acceptalert() {
		driver.switchTo().alert().accept();
	}

	public void dismisstalert() {
		driver.switchTo().alert().dismiss();
	}

	public void sendkeys(WebElement element, String keystosend) {
		element.sendKeys(keystosend);
	}

	public void scrolltoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}

	public void scrollbywindow(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void switchtochild() {
		Set<String> allwh = driver.getWindowHandles();
		System.out.println(allwh);
		for (String wh1 : allwh) {
			String title = driver.switchTo().window(wh1).getTitle();
			System.out.println(title);
		}

	}

	public void switchtoframe(String Titile) {
		Set<String> windows = driver.getWindowHandles();
		for (String id : windows) {
			String currenttitle = driver.switchTo().window(id).getTitle();
			System.out.println(currenttitle);
			if (currenttitle.contains(Titile)) {
				break;
			}
		}
	}
	public void sendkeysto(WebElement element ,String Keytosend) {
		element.sendKeys(Keytosend);

	}

}