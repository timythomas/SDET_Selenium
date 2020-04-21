package pages.DemoQASitePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import common.BaseClass;

public class SelectMenuPage extends BaseClass{


	static By header = By.xpath("//h1");
	static 	By SpeedMenu = By.xpath("//span[@id='speed-button']");
	static By speedMenuList = By.cssSelector("#speed-menu > li");
	static By filesMenu = By.xpath("//span[@id='files-button']");
	static By fileMenuList = By.cssSelector("#files-menu > li.ui-menu-item");
	static By numberMenu = By.xpath("//span[@id='number-button']");
	static By numberMenuList = By.cssSelector("#number-menu > li.ui-menu-item");
	static By titleMenu = By.xpath("//span[@id='salutation-button']");
	static By titleMenuList = By.xpath("//*[@id='salutation-menu']/li[@class='ui-menu-item']");
	static String optionVal="";

	public SelectMenuPage(WebDriver driver) {
		SelectMenuPage.driver = driver;
	}

	public static String verifyHeader() {
		return driver.findElement(header).getText();
	}

	public static void selectSpeedMenu() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(SpeedMenu).click();		
		List <WebElement> options = driver.findElements(speedMenuList);
		System.out.println(options.size());
		driver.findElement(SpeedMenu).click();	
		Thread.sleep(2000);
		for(WebElement option :options) {
			driver.findElement(SpeedMenu).click();
			optionVal=option.getText();
			option.click();	
			Thread.sleep(2000);
			Reporter.log("Speed option -"+optionVal+"- is selected");
		}
	}
	public static void selectFilesMenu() throws InterruptedException {
		driver.findElement(filesMenu).click();		
		List <WebElement> options = driver.findElements(fileMenuList);
		System.out.println(options.size());
		driver.findElement(filesMenu).click();	
		Thread.sleep(2000);
		for(WebElement option :options) {
			driver.findElement(filesMenu).click();
			optionVal=option.getText();
			option.click();	
			Thread.sleep(3000);
			Reporter.log("Files option -"+optionVal+"- is selected");
		}
	}
	public static void selectNumberMenu() throws InterruptedException {
		driver.findElement(numberMenu).click();		
		List <WebElement> options = driver.findElements(numberMenuList);
		System.out.println(options.size());
		driver.findElement(numberMenu).click();		
		Thread.sleep(2000);
		for(WebElement option :options) {
			driver.findElement(numberMenu).click();	
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", option );
			JavascriptExecutor jexec = (JavascriptExecutor) driver;
			jexec.executeScript("arguments[0].scrollIntoView(true);", option );
			optionVal=option.getText();
			option.click();	
			Thread.sleep(3000);
			Reporter.log("Number option -"+optionVal+"- is selected");
		}
	}
	public static void selectTitleMenu() throws InterruptedException {
		driver.findElement(titleMenu).click();		
		List <WebElement> options = driver.findElements(titleMenuList);
		System.out.println(options.size());
		driver.findElement(titleMenu).click();		
		Thread.sleep(2000);
		for(WebElement option :options) {
			driver.findElement(titleMenu).click();	
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", option );
			JavascriptExecutor jexec = (JavascriptExecutor) driver;
			jexec.executeScript("arguments[0].scrollIntoView(true);", option );
			optionVal=option.getText();
			option.click();	
			Thread.sleep(3000);
			Reporter.log("Title option -"+optionVal+"- is selected");
		}
	}
}
