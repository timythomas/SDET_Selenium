package pages.DemoQASitePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.BaseClass;

public class DatePickerPage extends BaseClass{


	static By header = By.xpath("//h1");
	static By dateText = By.xpath("//input[@id='datepicker']");
	static By prevCal = By.cssSelector("a.ui-datepicker-prev.ui-corner-all");
	static By dtPickerMonth = By.xpath("//span[@class='ui-datepicker-month']");
	static By dtPickerDate = By.xpath("//a[@class='ui-state-default']");
	static By dtPickerYear = By.xpath("//span[@class='ui-datepicker-year']");

	public DatePickerPage(WebDriver driver) {
		DatePickerPage.driver = driver;
	}

	public static String verifyHeader() {
		return driver.findElement(header).getText();
	}

	public static void pickDate(String birthDate, String birthMonth, String birthYear) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dateText));
		driver.findElement(dateText).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(prevCal));
		String currentYear = driver.findElement(dtPickerYear).getText();
		String currentMonth = driver.findElement(dtPickerMonth).getText();
		//Navigate to Year
		while (!currentYear.equals(birthYear)) {
			driver.findElement(prevCal).click();
			currentYear = driver.findElement(dtPickerYear).getText();
		}
		//Navigate to Month
		while (!currentMonth.equals(birthMonth)) {
			driver.findElement(prevCal).click();
			currentMonth = driver.findElement(dtPickerMonth).getText();
		}
		List<WebElement> dateVal = driver.findElements(dtPickerDate);
		//Select date
		for (WebElement ele : dateVal) {
			if (ele.getText().equals(birthDate)) {
				ele.click();
				break;
			}

		}

	}

}
