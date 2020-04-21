package pages.DemoQASitePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import common.BaseClass;

public class SelectablePage extends BaseClass{

	static By item = By.cssSelector("#selectable > li");

	public SelectablePage(WebDriver driver) {
		SelectablePage.driver = driver;
	}

	public static void clickOnItem(WebElement ele) {
		ele.click();
		Reporter.log("Item clicked -->");
	}

	public static void getItemName(WebElement ele) {
		String itemName = ele.getText();
		Reporter.log("Item Name <--" + itemName);
	}

	public static void verifyClickAndPrint() {
		List<WebElement> ele = driver.findElements(item);
		for (WebElement el : ele) {
			clickOnItem(el);
			getItemName(el);

		}
	}

}
