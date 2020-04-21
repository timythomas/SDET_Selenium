package pages.OlaySitePages;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import common.*;

public class RegisterPage extends BaseClass {

	static By header = By.xpath("//h1");
	static By descriptionLabel = By.xpath("//h2[@id='phdesktopbody_1_Description']");
	static By registerLink = By.xpath("(//a[@class='event_profile_register'])[1]");
	static By femaleImage = By.cssSelector("img#phdesktopbody_0_imgfemale");
	static By maleImage = By.cssSelector("img#phdesktopbody_0_imgmale");
	static By firstNameInput = By.cssSelector("input#phdesktopbody_0_grs_consumer\\[firstname\\]");
	static By lastNameInput = By.cssSelector("input#phdesktopbody_0_grs_consumer\\[lastname\\]");
	static By emailInput = By.cssSelector("input#phdesktopbody_0_grs_account\\[emails\\]\\[0\\]\\[address\\]");
	static By passwordInput = By.cssSelector("input#phdesktopbody_0_grs_account\\[password\\]\\[password\\]");
	static By confirmPassword = By.cssSelector("input#phdesktopbody_0_grs_account\\[password\\]\\[confirm\\]");
	static By birthDaySelect = By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][day]");
	static By birthMonthSelect = By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][month]");
	static By birthYearSelect = By.name("phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][year]");
	static By registerAndCreateButton = By.xpath("//input[@id='phdesktopbody_0_submit']");
	static By countrySelect = By.id("phdesktopbody_0_labelgrs_account[addresses][0][country]");
	static By streetAddrInput = By
			.cssSelector("input#phdesktopbody_0_labelgrs_account\\[addresses\\]\\[0\\]\\[line1\\]");
	static By postCodeInput = By.cssSelector("input#phdesktopbody_0_grs_account\\[addresses\\]\\[0\\]\\[postalarea\\]");
	static By cityInput = By.cssSelector("input#phdesktopbody_0_labelgrs_account\\[addresses\\]\\[0\\]\\[city\\]");
	static By phoneInput = By
			.cssSelector("input#phdesktopbody_0_grs_account\\[phones\\]\\[0\\]\\[fulltelephonenumber\\]");
	static By checkbox = By.xpath("//input[@id='phdesktopbody_0_ctl74']");
	By submitButton = By.cssSelector("#phdesktopbody_0_SIGN\\ IN");
	By invalidFieldErrorMsg = By.cssSelector("#phdesktopbody_0_Message");
	By forgotPassword = By.xpath("a#phdesktopbody_0_forgotpassword");

	public RegisterPage(WebDriver driver) {
		RegisterPage.driver = driver;
	}

	public String verifyHeader() {
		return driver.findElement(header).getText();
	}

	public static void verifyHeader2(String lang) {
		if (lang.equals("UK")) {

		} else if (lang.equals("Germany")) {

		} else if (lang.equals("Spain")) {

		}
		String headerVal = driver.findElement(descriptionLabel).getText();
		assertTrue(headerVal.contains("Thank you for signing up to Club Olay!"));
	}

	public static void userRegister(HashMap<String, String> val, String lang)
			throws InterruptedException, ParseException {
		driver.findElement(registerLink).click();
		Reporter.log("Register link clicked");
		if (lang.equals("Germany") || lang.equals("Spain")) {
			if (val.get("Gender").equalsIgnoreCase("Female")) {
				driver.findElement(femaleImage).click();
			} else {
				driver.findElement(maleImage).click();
			}
			Reporter.log("Gender selected");
			driver.findElement(firstNameInput).sendKeys(val.get("FirstName"));
			Reporter.log("First Name entered");
			driver.findElement(lastNameInput).sendKeys(val.get("LastName"));
			Reporter.log("Last Name entered");
		}
		driver.findElement(emailInput).sendKeys(val.get("EmailAddress"));
		Reporter.log("Enter Email Id");
		driver.findElement(passwordInput).sendKeys(val.get("Password"));
		Reporter.log("Passowrd entered");
		driver.findElement(confirmPassword).sendKeys(val.get("Password"));
		Reporter.log("Confirm Passowrd entered");
		selectDropdownValue(val.get("Day"), birthDaySelect);
		Reporter.log("Birth Day selected");
		selectDropdownValue(val.get("Month"), birthMonthSelect);
		Reporter.log("Birth Month selected");
		selectDropdownValue(val.get("Year"), birthYearSelect);
		Reporter.log("Birth Year selected");
		if (lang.equals("Germany")) {
			WebElement element = driver.findElement(countrySelect);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(5000);
			selectDropdownValue(val.get("country"), countrySelect);
			Reporter.log("Country Selected");
			driver.findElement(streetAddrInput).sendKeys(val.get("StreetAddress"));
			Reporter.log("Street Address entered");
			driver.findElement(postCodeInput).sendKeys(val.get("PostCode"));
			Reporter.log("Postal code entered");
			driver.findElement(cityInput).sendKeys(val.get("City"));
			Reporter.log("City entered");
		}
		if (lang.equals("Spain")) {
			driver.findElement(phoneInput).sendKeys(val.get("phoneNumber"));
			Reporter.log("Phone number enetered");
			driver.findElement(checkbox).click();
		}
		registerButton();
		Thread.sleep(5000);

	}

	public static void registerButton() throws InterruptedException {
		WebElement element = driver.findElement(registerAndCreateButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		driver.findElement(registerAndCreateButton).click();
		Reporter.log("Register button clicked");
	}

	public static HashMap<String, String> registerValuesUK(HashMap<String, String> val) throws ParseException {
		HashMap<String, String> registerVal = new HashMap<String, String>();
		registerVal.put("EmailAddress", generateRandomUser(val.get("EmailAddress")));
		registerVal.put("Password", val.get("Password"));
		String[] dt = dateParse(val.get("Birthday")).split("-");
		registerVal.put("Day", dt[0]);
		registerVal.put("Month", dt[1]);
		registerVal.put("Year", dt[2]);
		return registerVal;
	}

	public static String generateRandomUser(String emailAddress) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		return randomInt + emailAddress;
	}

	public static String dateParse(String birthday) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
		Date dt = format.parse(birthday);

		String month = new SimpleDateFormat("MM").format(dt);
		String year = new SimpleDateFormat("yyyy").format(dt);
		String day = new SimpleDateFormat("dd").format(dt);
		return day + "-" + month + "-" + year;
	}

	public static void selectDropdownValue(String value, By element) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

		WebElement testDropDown = driver.findElement(element);
		Select drop = new Select(testDropDown);
		drop.selectByValue(value);

	}

	public static HashMap<String, String> registerValuesGermany() throws ParseException, IOException {
		HashMap<String, String> registerVal = new HashMap<String, String>();
		registerVal.put("Gender", ExcelReader.readExcelData(1, 0));
		registerVal.put("FirstName", ExcelReader.readExcelData(1, 1));
		registerVal.put("LastName", ExcelReader.readExcelData(1, 2));
		registerVal.put("EmailAddress", ExcelReader.readExcelData(1, 3));
		registerVal.put("Password", ExcelReader.readExcelData(1, 4));
		String[] dt = dateParse(ExcelReader.readExcelData(1, 5)).split("-");
		registerVal.put("Day", dt[0]);
		registerVal.put("Month", dt[1]);
		registerVal.put("Year", dt[2]);
		registerVal.put("country", ExcelReader.readExcelData(1, 6));
		registerVal.put("StreetAddress", ExcelReader.readExcelData(1, 7));
		registerVal.put("PostCode", ExcelReader.readExcelData(1, 8));
		registerVal.put("City", ExcelReader.readExcelData(1, 9));
		return registerVal;
	}

	public static HashMap<String, String> registerValuesSpanish()
			throws ParseException, IOException, org.json.simple.parser.ParseException {
		HashMap<String, String> registerVal = new HashMap<String, String>();
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\util\\dataFILe.json");
		Object obj = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) obj;
		System.out.println(usersList);
			JSONObject users = (JSONObject) usersList.get(0);
			System.out.println(users);// This prints every block - one json object
			JSONObject user = (JSONObject) users.get("users");
			
		registerVal.put("Gender", (String) user.get("gender"));
		registerVal.put("FirstName", (String) user.get("firstName"));
		registerVal.put("LastName", (String) user.get("lastName"));
		registerVal.put("EmailAddress", (String) user.get("emailAddress"));
		registerVal.put("Password", (String) user.get("password"));
		String[] dt = dateParse((String) user.get("birthday")).split("-");
		registerVal.put("Day", dt[0]);
		registerVal.put("Month", dt[1]);
		registerVal.put("Year", dt[2]);
		registerVal.put("phoneNumber",(String) user.get("phoneNumber"));
		return registerVal;
	}

}
