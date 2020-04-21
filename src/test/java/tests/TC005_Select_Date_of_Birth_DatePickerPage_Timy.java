package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseClass;
import pages.DemoQASitePages.DatePickerPage;

public class TC005_Select_Date_of_Birth_DatePickerPage_Timy extends BaseClass{

	@Test
	public void clickAndPrintItem() throws InterruptedException {
		driver.get("https://demoqa.com/datepicker/");
		Assert.assertEquals(DatePickerPage.verifyHeader(), "Datepicker");
		DatePickerPage.pickDate("21", "August", "1990");
	}
}
