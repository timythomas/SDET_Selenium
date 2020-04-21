package pages.OlaySitePages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import common.*;

public class LoginPage extends BaseClass {

	static By header = By.xpath("//h1");
	static By signInLink=By.xpath("//a[@class='event_profile_login']");
	static By emailInput=By.cssSelector("input#phdesktopbody_0_username");
	static By passwordInput=By.xpath("//input[@type='password']");
	static By signInButton=By.xpath("//input[@type='submit']");
	static By invalidFieldErrorMsg=By.cssSelector("#phdesktopbody_0_Message");
	static By forgotPassword=By.cssSelector("a#phdesktopbody_0_forgotpassword");
	static By logoutButton=By.xpath("//a[@id='phdesktopheader_0_phdesktopheadertop_2_LogOffLink']");
	static By confirmLogoutButton=By.cssSelector("a#phdesktopheader_0_phdesktopheadertop_2_anchrContinue");
	static By afterForgotPasswordMsg=By.cssSelector("div#phdesktopbody_0_afterSubmit");
	static By nextButton=By.xpath("//input[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
	}

	public static void verifyHeader(String lang) {
		String expectVal="";
		if(lang.equals("UK")) {
			expectVal="SIGN IN";
		}
		else if(lang.equals("Germany")) {
			expectVal="Anmelden";

		}
		else if(lang.equals("Spain")) {
			expectVal="INICIA SESIÓN ";
		}
		String headerVal= driver.findElement(header).getText(); 
		assertTrue(headerVal.contains(expectVal));
	}

	public static void userLogin(HashMap<String, String> val, String lang) throws InterruptedException, ParseException {
		driver.findElement(signInLink).click();
		verifyHeader(lang);
		driver.findElement(emailInput).sendKeys(val.get("EmailAddress"));
		Reporter.log("Enter Email Id");
		driver.findElement(passwordInput).sendKeys(val.get("Password"));
		Reporter.log("Enter Passowrd");
		driver.findElement(signInButton).click();
		Reporter.log("Sign In button clicked");
	}
	public static void logout() {
		driver.findElement(logoutButton).click();
		driver.findElement(confirmLogoutButton).click();
		Reporter.log("User Logged out!");
				
	}
	public static void loginLanguage(String language) throws IOException {
		driver.get(getProperty(language));		
	}
	
	public static void verifyInvalidLogin(String expectVal) {
		String errorMsg=driver.findElement(invalidFieldErrorMsg).getText();
		assertTrue(errorMsg.contains(expectVal));
	}
	public static void verifyforgotPwd(HashMap<String, String> val,String expectVal) {
		driver.findElement(signInLink).click();

		driver.findElement(forgotPassword).click();
		driver.findElement(emailInput).sendKeys(val.get("EmailAddress"));
		Reporter.log("Enter Email Id");
		driver.findElement(nextButton).click();
		String errorMsg=driver.findElement(afterForgotPasswordMsg).getText();
		assertTrue(errorMsg.contains(expectVal));
	}
}
