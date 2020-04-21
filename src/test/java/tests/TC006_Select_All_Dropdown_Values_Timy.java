package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseClass;
import pages.DemoQASitePages.SelectMenuPage;

public class TC006_Select_All_Dropdown_Values_Timy extends BaseClass{

	@Test
	public static void clickAndPrintItem() throws InterruptedException {
		driver.get("https://demoqa.com/selectmenu/");
		Assert.assertEquals(SelectMenuPage.verifyHeader(), "Selectmenu");
		SelectMenuPage.selectSpeedMenu();
		SelectMenuPage.selectFilesMenu();
		SelectMenuPage.selectNumberMenu();
		SelectMenuPage.selectTitleMenu();
	}
}
