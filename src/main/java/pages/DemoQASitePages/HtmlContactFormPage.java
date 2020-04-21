package pages.DemoQASitePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import common.BaseClass;

public class HtmlContactFormPage extends BaseClass{

	static By firstNameInput = By.cssSelector(".firstname");
	static By lastNameInput = By.cssSelector("#lname");
	static By countryInput = By.xpath("//input[@name='country']");
	static By subjectInput = By.xpath("//textarea[@id='subject']");
	static By submitButton = By.xpath("//input[@type='submit']");
	static By pageTitleAftrSubmit = By.cssSelector(".page-title");
	static By header = By.xpath("//h1");
	static By link = By.partialLinkText("Google Link");

	public HtmlContactFormPage(WebDriver driver) {
		HtmlContactFormPage.driver = driver;
	}

	public static void enterText(By byVal, String inputVal) {
		driver.findElement(byVal).sendKeys(inputVal);
		Reporter.log("Text Entered -->");
	}

	public static void clickButton(By byVal) {
		driver.findElement(byVal).click();
		Reporter.log("Button clicked -->");

	}

	public static String verifyPageTitle() {
		return driver.findElement(pageTitleAftrSubmit).getText();

	}

	public static String verifyHeader() {
		return driver.findElement(header).getText();
	}

	public static void fillForm(String fname, String lname, String country, String subject) {
		enterText(firstNameInput, fname);
		Reporter.log("First name entered");
		enterText(lastNameInput, lname);
		Reporter.log("Last name entered");
		enterText(countryInput, country);
		Reporter.log("Country name entered");
		enterText(subjectInput, subject);
		Reporter.log("Subject entered");
		clickButton(submitButton);
		Reporter.log("Submit button clicked");

	}

	public static void verifyLink(String Link1, String Link2) throws InterruptedException {
		List<WebElement> ele = driver.findElements(link);
		ele.get(0).getText().equals(Link1);
		Reporter.log(ele.get(0).getText() + " is visible");
		ele.get(1).getText().equals(Link2);
		Reporter.log(ele.get(1).getText() + " is visible");
		openLinksNewTab(ele.get(0));
		openLinksNewTab(ele.get(1));

	}

	public static void openLinksNewTab(WebElement ele) throws InterruptedException {
		String newTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		ele.sendKeys(newTab);
		Reporter.log(ele.getText() + " link is opened in New Tab");
	}

}
