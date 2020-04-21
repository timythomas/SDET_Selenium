package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseClass;
import pages.DemoQASitePages.HtmlContactFormPage;

public class TC003_VerifyLinksAndOpenInNewTab_HtmlcontactformPage_Timy extends BaseClass{

	@Test
	public void verifyLinksAndOpenInNewTab() throws InterruptedException {
		
		driver.get("https://demoqa.com/html-contact-form/");
		Assert.assertEquals(HtmlContactFormPage.verifyHeader(), "HTML contact form");
		HtmlContactFormPage.verifyLink("Google Link", "Google Link is here");
	}
}
