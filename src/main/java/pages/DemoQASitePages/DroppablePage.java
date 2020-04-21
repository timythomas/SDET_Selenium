package pages.DemoQASitePages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import common.BaseClass;

public class DroppablePage extends BaseClass{

	
	static By header =By.xpath("//h1");
	static By dragBlock= By.id("draggable");
	static By dropBlock= By.id("droppable");
	static By dropText= By.xpath("//div[@id=\"droppable\"]/p");
	static By demoFrame=By.cssSelector(".demo-frame");
	
	public DroppablePage(WebDriver driver) {
		DroppablePage.driver = driver;
	}

	public static String verifyHeader() {
		return driver.findElement(header).getText();
	}
	
	public static void dragBlock() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(demoFrame));
		Actions act= new Actions(driver);
		WebElement dragFrom= driver.findElement( dragBlock);
		WebElement dropTo=driver.findElement( dropBlock);
		act.dragAndDrop(dragFrom, dropTo).perform();
		Reporter.log("Dragged and Dropped the Block !!!");
	}
	
	public static String dropText() {
		return driver.findElement(dropText).getText();
		
	}
}
