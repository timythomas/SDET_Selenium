package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import common.BaseClass;
import pages.DemoQASitePages.SelectablePage;



public class TC001_Click_Item_And_Print_Item_Name_SelectablePage_Timy extends BaseClass{

	@Test
	public void clickAndPrintItem() {
		driver.get("https://demoqa.com/selectable/");
		SelectablePage.verifyClickAndPrint();
	}
}
