package pages.DemoQASitePages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import common.BaseClass;

public class ControlGroupPage extends BaseClass {

	static WebDriver driver;

	static By header = By.xpath("//h1");
	static By horzCartypeMenu = By.xpath("//span[@id='car-type-button']");
	static By horzCarTypeSelect = By.cssSelector("#car-type-menu > li");
	static By horzStandardRadio = By.xpath("//input[@id='transmission-standard']/preceding::label");
	static By horzAutomaticRadio = By
			.xpath("//input[@id='transmission-automatic']/preceding::label[@for='transmission-standard']");
	static By horzInsuranceCheck = By.xpath("//input[@id='insurance']/preceding::label[@for='insurance']");
	static By horzIncreaseCarCount = By.xpath(
			"//label[@for='horizontal-spinner']/following-sibling::span/a/span[@class='ui-button-icon ui-icon ui-icon-triangle-1-n']");
	static By horzDecreaseCarCount = By.xpath(
			"//label[@for='horizontal-spinner']/following-sibling::span/a/span[@class='ui-button-icon ui-icon ui-icon-triangle-1-s']");
	static By horzBookNowBttn = By.xpath("//label[@for='horizontal-spinner']/following-sibling::button");

	static By vertCartypeMenu = By.xpath("//span[@id='ui-id-8-button']");
	static By vertCarTypeSelect = By.cssSelector("#ui-id-8-menu > li");
	static By vertStandardRadio = By.xpath("//input[@id='transmission-standard-v']/preceding-sibling::label");
	static By vertAutomaticRadio = By
			.xpath("//input[@id='transmission-automatic-v']/preceding-sibling::label[@for='transmission-standard-v']");
	static By vertInsuranceCheck = By.xpath("//input[@id='insurance-v']/preceding::label[@for='insurance-v']");
	static By vertIncreaseCarCount = By.xpath(
			"//input[@id='vertical-spinner']/following::span[@class='ui-button-icon ui-icon ui-icon-triangle-1-n']");
	static By vertDecreaseCarCount = By.xpath(
			"//input[@id='vertical-spinner']/following::span[@class='ui-button-icon ui-icon ui-icon-triangle-1-s']");
	static By vertBookNowBttn = By.xpath("//input[@id='vertical-spinner']/following::button");
	
	public ControlGroupPage(WebDriver driver) {
		ControlGroupPage.driver = driver;
	}

	public static String verifyHeader() {
		return driver.findElement(header).getText();
	}

	public static void RentalCarBook_Horz(HashMap<String, String> rentalVal) throws InterruptedException {
		Reporter.log("------Horizontal Car Block-----");
		driver.findElement(horzCartypeMenu).click();
		List<WebElement> ele = driver.findElements(horzCarTypeSelect);
		for (WebElement el : ele) {
			if (el.getText().equals(rentalVal.get("carType"))) {
				el.click();
				break;
			}
		}
		Reporter.log("Car Type -" + rentalVal.get("carType") + "- Select");
		if (rentalVal.get("standardType").equalsIgnoreCase("true")) {
			driver.findElement(horzStandardRadio).click();
			Reporter.log("StandardType selected");
		}
		if (rentalVal.get("automaticType").equalsIgnoreCase("true")) {
			driver.findElement(horzAutomaticRadio).click();
			Reporter.log("AutomaticType selected");
		}
		if (rentalVal.get("insuranceType").equalsIgnoreCase("true")) {
			driver.findElement(horzInsuranceCheck).click();
			Reporter.log("AutomaticType selected");
		}
		int carCount = Integer.parseInt(rentalVal.get("carNumbers"));
		if (carCount > 0) {
			for (int i = 0; i < carCount; i++) {
				driver.findElement(horzIncreaseCarCount).click();
			}

		} else {
			for (int i = 0; i > carCount; i--) {
				driver.findElement(horzDecreaseCarCount).click();
			}
		}
		Reporter.log("Number of Cars selected");
		
		driver.findElement(horzBookNowBttn).click();
		Reporter.log("Book Now button Clicked");
	}
	
	public static void RentalCarBook_vert(HashMap<String, String> rentalVal) throws InterruptedException {
		Reporter.log("------Vertical Car Block------");
		driver.findElement(vertCartypeMenu).click();
		List<WebElement> ele = driver.findElements(vertCarTypeSelect);
		for (WebElement el : ele) {
			if (el.getText().equals(rentalVal.get("carType"))) {
				el.click();
				break;
			}
		}
		Reporter.log("Car Type -" + rentalVal.get("carType") + "- Select");
		if (rentalVal.get("standardType").equalsIgnoreCase("true")) {
			driver.findElement(vertStandardRadio).click();
			Reporter.log("StandardType selected");
		}
		if (rentalVal.get("automaticType").equalsIgnoreCase("true")) {
			driver.findElement(vertAutomaticRadio).click();
			Reporter.log("AutomaticType selected");
		}
		if (rentalVal.get("insuranceType").equalsIgnoreCase("true")) {
			driver.findElement(vertInsuranceCheck).click();
			Reporter.log("AutomaticType selected");
		}
		int carCount = Integer.parseInt(rentalVal.get("carNumbers"));
		if (carCount > 0) {
			for (int i = 0; i < carCount; i++) {
				driver.findElement(vertIncreaseCarCount).click();
			}

		} else {
			for (int i = 0; i > carCount; i--) {
				driver.findElement(vertDecreaseCarCount).click();
			}
		}
		Reporter.log("Number of Cars selected");
		
		driver.findElement(vertBookNowBttn).click();
		Reporter.log("Book Now button Clicked");
	}
	
}
