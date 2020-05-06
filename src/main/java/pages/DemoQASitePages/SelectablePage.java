package pages.DemoQASitePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import common.BaseClass;

public class SelectablePage extends BaseClass{

	static By item = By.cssSelector("#selectable > li");
	static By itemSelected=By.xpath("//li[@class='ui-widget-content ui-selectee ui-selected']");

	public SelectablePage(WebDriver driver) {
		SelectablePage.driver = driver;
	}

	public static void clickOnItem(WebElement ele) {
		ele.click();
		Reporter.log("Item clicked -->");
	}

	public static String getItemName(WebElement ele) {
		String itemName = ele.getText();
		Reporter.log("Item Name <--" + itemName);
		return itemName;
	}

	public static void verifyClickAndPrint() {
		List<WebElement> ele = driver.findElements(item);
		for (WebElement el : ele) {
			clickOnItem(el);
			verifySelectedItem(getItemName(el));

		}
	}
	
	public static void verifySelectedItem(String val ) {
		String expVal=driver.findElement(itemSelected).getText();
		System.out.println("Selected -- "+val+" ExpectedSelect -- "+expVal);
		Assert.assertEquals(val, expVal);
	}

}
