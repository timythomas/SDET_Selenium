package pages.DemoQASitePages;

import java.util.List;

import javax.security.sasl.SaslException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import common.BaseClass;
import junit.framework.Assert;

public class SelectMenuPage extends BaseClass{


	static By header = By.xpath("//h1");
	static 	By SpeedMenu = By.xpath("//span[@id='speed-button']");
	static By speedMenuList = By.cssSelector("#speed-menu > li");
	static By selectSpeedValue=By.cssSelector("#speed-button > span.ui-selectmenu-text");
	static By filesMenu = By.xpath("//span[@id='files-button']");
	static By fileMenuList = By.cssSelector("#files-menu > li.ui-menu-item");
	static By selectFileValue=By.cssSelector("#files-button > span.ui-selectmenu-text");
	static By numberMenu = By.xpath("//span[@id='number-button']");
	static By numberMenuList = By.cssSelector("#number-menu > li.ui-menu-item");
	static By selectNumberValue=By.cssSelector("#number-button > span.ui-selectmenu-text");
	static By titleMenu = By.xpath("//span[@id='salutation-button']");
	static By titleMenuList = By.xpath("//*[@id='salutation-menu']/li[@class='ui-menu-item']");
	static By selectTitleValue=By.cssSelector("#salutation-button > span.ui-selectmenu-text");
	static String optionVal="";

	public SelectMenuPage(WebDriver driver) {
		SelectMenuPage.driver = driver;
	}

	public static String verifyHeader() {
		return driver.findElement(header).getText();
	}

	public static void selectSpeedMenuAndVerify() throws InterruptedException {
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
			verifySelectedValue(selectSpeedValue,optionVal);
		}
		
		
	}
	
	
	public static void verifySelectedValue(By uiVal,String selectedVal) {
		String val=driver.findElement(uiVal).getText();
		Assert.assertEquals(val, selectedVal);
		System.out.println("Pass");
	}
	public static void selectFilesMenuAndVerify() throws InterruptedException {
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
			verifySelectedValue(selectFileValue,optionVal);

		}
	}
	public static void selectNumberMenuAndVerify() throws InterruptedException {
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
			verifySelectedValue(selectNumberValue,optionVal);

		}
	}
	public static void selectTitleMenuAndVerify() throws InterruptedException {
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
			verifySelectedValue(selectTitleValue,optionVal);

		}
	}
}
