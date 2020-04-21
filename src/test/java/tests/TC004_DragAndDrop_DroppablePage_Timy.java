package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseClass;
import pages.DemoQASitePages.DroppablePage;

public class TC004_DragAndDrop_DroppablePage_Timy extends BaseClass{

	@Test
	public static void clickAndPrintItem() throws InterruptedException {
		
		driver.get("https://demoqa.com/droppable/");
		Assert.assertEquals(DroppablePage.verifyHeader(), "Droppable");
		DroppablePage.dragBlock();
		Thread.sleep(5000);
		Assert.assertEquals(DroppablePage.dropText(), "Dropped!");
	}
}
