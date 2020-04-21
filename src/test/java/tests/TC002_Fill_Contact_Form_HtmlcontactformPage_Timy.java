package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseClass;
import pages.DemoQASitePages.HtmlContactFormPage;

public class TC002_Fill_Contact_Form_HtmlcontactformPage_Timy extends BaseClass{

	@Test
	public void fillForm() {
		driver.get("https://demoqa.com/html-contact-form/");
		Assert.assertEquals(HtmlContactFormPage.verifyHeader(), "HTML contact form");
		HtmlContactFormPage.fillForm("Mathew", "Andri", "US", "Text in Text Area");
		Assert.assertEquals(HtmlContactFormPage.verifyPageTitle(), "Oops! That page can’t be found.");
	}
}
