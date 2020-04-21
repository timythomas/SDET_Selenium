package pages.DemoQASitePages.MakeMyTripPages;

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

import common.BaseClass;

public class HomePage extends BaseClass{


	static By header = By.xpath("//h1");
	static By oneWayRadio = By.xpath("//li[text()='Oneway']");
	static By roundTripRadio = By.xpath("//li[text()='Round Trip']");
	static By multiCityRadio = By.xpath("//li[text()='Multi City']");
	static By fromCityField = By.cssSelector("#fromCity");
	static By fromCityInput = By.xpath("//div[@role='combobox']/input");
	static By fromCitySelect = By.cssSelector("#react-autowhatever-1-section-0-item-0");
	static By toCityText = By.cssSelector("#toCity");
	static By toCityInput = By.xpath("//div[@role='combobox']/input");
	static By toCitySelect = By.cssSelector("#react-autowhatever-1-section-0-item-0");
	static By deptDateField = By.xpath("//span[@class='selectedDateField appendBottom8']");
	static By deptDateLabel = By.xpath("//p[@data-cy='departureDate']/span[@class='font30 latoBlack ']");
	static By deptMonthLabel = By
			.xpath("//p[@data-cy='departureDate']/span[@class='font30 latoBlack ']/following-sibling::span[1]");
	static By deptYearLabel = By.xpath("//p[@data-cy='departureDate']/span[@class='shortYear']");
	static By searchButton = By.xpath("//p[@data-cy='submit']/a");
	static By travellerLabel = By.xpath("//label[@for='travellers']");
	static By adultInput = By.xpath("//p[@data-cy='adultRange']/following-sibling::ul/li[contains(@data-cy,'adults')]");
	static By childInput = By.xpath("//p[@data-cy='childrenRange']/following-sibling::ul/li[contains(@data-cy,'children')]");
	static By infantInput = By.xpath("//p[@data-cy='infantRange']/following-sibling::ul/li[contains(@data-cy,'infants')]");
	static By travelClassInput = By
			.xpath("//p[@data-cy='chooseTravelClass']/following-sibling::ul/li[contains(@data-cy,'travelClass')]");

	static By applyButton = By.xpath("//button[text()='APPLY']");
	static By calNext = By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']");
	static By travellingFor = By.xpath("//label[@data-cy='travellingFor']");
	static By travellingReason = By.xpath("//ul[@class='travelForPopup']/li");
	static By sortPriceLabel=By.xpath("//span[@class='pointer']/span[text()='Price']");
	static By sortPricedownArrow=By.xpath("//span[@class='pointer']/span[@class='down sort-arrow']");
	static By sortPriceUpArrow=By.xpath("//span[@class='pointer']/span[@class='up sort-arrow']");
	static By viewFaresSelect=By.xpath("(//div//button[text()='View Fares'])[1]");
	static By viewFaresBookNowButton=By.xpath("(//button[contains(text(),'Book Now')] )[1]");
	static By bookNowButton=By.xpath("(//button[contains(text(),'Book Now')] )[1]");
	static By airplaneName=By.xpath("//div[@class='card-upperpart-wrapper']//div//span[@class='airways-name ']");
	static By roundAirplaneName=By.xpath("(//span[@class='airways-name '])[1]");
	static By departTime=By.xpath("//div[@class='card-upperpart-wrapper']//div//div[@class='dept-time']");
	static By roundDepartTime=By.xpath("(//div[@class='dept-time'])[1]");
	static By getDepartureCity=By.xpath("//div[@class='card-upperpart-wrapper']//div//p[@class='dept-city']");
	static By getRoundDepartureCity=By.xpath("(//p[@class='dept-city'])[1]");
	static By getArrivalCity=By.xpath("//div[@class='card-upperpart-wrapper']//div//p[@class='arrival-city']");
	static By getRoundArrivalCity=By.xpath("(//p[@class='arrival-city'])[1]");
	static By returnDepartCity=By.xpath("(//p/span[text()='Return']/following::p[@class='dept-city'])[1]");
	static By returnDepartTime=By.xpath("(//p/span[text()='Return']/following::div[@class='dept-time'])[1]");
	static By returnArriveCity=By.xpath("(//p/span[text()='Return']/following::p[@class='arrival-city'])[1]");
	
	
	static By selectedAirplanename=By.xpath("(//p[@class='append_bottom5 font14 LatoBold'])[1]");
	static By selectedDepartTime=By.xpath("(//div[@class='dept-time append_bottom3 make_relative'])[1]");
	static By selectedDepartureCity=By.xpath("(//p[@class='dept-city']/span[@class='LatoBold'])[1]");
	static By selectedArrivalCity=By.xpath("(//p[@class='arrival-city']/span[@class='LatoBold'])[1]");
	
	static By selectedOnwardArrivalCity=By.xpath("(//p[@class='arrival-city']/span[@class='LatoBold'])[1]");
	public HashMap<String,String> flightVal=new HashMap<String, String>();
	public HashMap<String,String> getflightVal=new HashMap<String, String>();
	public HashMap<String,String> getOnwardVal=new HashMap<String, String>();
	public HashMap<String,String> getReturnVal=new HashMap<String, String>();
	public HashMap<String,String> getSelectReturnVal=new HashMap<String, String>();
	public HashMap<String,String> getSelectOnwardVal=new HashMap<String, String>();

	static By sortOnwardPrice= By.xpath("//button[@id='sorter_btn_onward']");
	static By sortReturnPrice= By.xpath("//button[@id='sorter_btn_return']");
	static By selectOnwardLowPrice=By.xpath("//button[@id='sorter_btn_onward']/following-sibling::ul//span[text()='Price']");
	static By selectReturnLowPrice=By.xpath("//button[@id='sorter_btn_return']/following-sibling::ul//span[text()='Price']");

	static By selectReturnDepartCity=By.xpath("(//p[@class='dept-city'])[2]");
	static By selectReturnDepartTime=By.xpath("(//div[@class='dept-time append_bottom3 make_relative'])[2]");
	static By selectReturnArriveCity=By.xpath("(//p[@class='arrival-city'])[2]");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyHeader() {
		return driver.findElement(header).getText(); 
	}

	public void oneWayTrip(HashMap<String, String> val) throws InterruptedException, ParseException {
		driver.findElement(oneWayRadio).click();
		Reporter.log("One Way is selected");
		WebElement ele = driver.findElement(fromCityField);
		ele.click();
		selectFromCity(val);
		selectToCity(val);
		Thread.sleep(5000);
		selectDate(val.get("DepartureDate"),"OneWay");		
		selectPassengerClass(val);
		selectTravelReason(val);
		driver.findElement(searchButton).click();
		sortPrice("Cheapest");
		selectFlight();
	}
	public void roundTrip(HashMap<String, String> val) throws InterruptedException, ParseException {
		driver.findElement(roundTripRadio).click();
		Reporter.log("One Way is selected");
		WebElement ele = driver.findElement(fromCityField);
		ele.click();
		selectFromCity(val);
		selectToCity(val);
		Thread.sleep(5000);
		selectDate(val.get("DepartureDate"),"RoundTrip");
		selectDate(val.get("ReturnDate"),"RoundTrip");		
		selectPassengerClass(val);
		//selectTravelReason(val);
		driver.findElement(searchButton).click();
		sortPrice("Cheapest");
		//sortRoundTripPrice();
		selectRoundTripFlight();
	}
	
	public String getArrivalCity() {
		List<WebElement> travelEle = driver.findElements(selectedArrivalCity);
		WebElement lastElement = travelEle.get(travelEle.size() - 1); 
		return lastElement.getText();
		
	}

	public void selectFromCity(HashMap<String, String> val) throws InterruptedException {
		driver.findElement(fromCityInput).sendKeys(val.get("FromCity"));
		Thread.sleep(7000);
		driver.findElement(fromCitySelect).click();
		Reporter.log("From City is selected");
	}

	public void selectToCity(HashMap<String, String> val) throws InterruptedException {
		driver.findElement(toCityInput).sendKeys(val.get("ToCity"));
		Thread.sleep(7000);

		driver.findElement(toCitySelect).click();
		Reporter.log("To City is selected");
	}

	public void selectTravelReason(HashMap<String, String> val) {
		driver.findElement(travellingFor).click();

		List<WebElement> travelEle = driver.findElements(travellingReason);
		for (WebElement e : travelEle) {
			if (e.getText().equalsIgnoreCase(val.get("travellingReason"))) {
				e.click();
				break;
			}
		}
		Reporter.log("Travel reason is selected");
	}

	public void selectPassengerClass(HashMap<String, String> val) {
		driver.findElement(travellerLabel).click();
		if (Integer.parseInt(val.get("adultCount")) > 0) {

			List<WebElement> ainput = driver.findElements(adultInput);
			for (WebElement e : ainput) {
				if (e.getText().equalsIgnoreCase(val.get("adultCount"))) {
					e.click();
				}
			}
		}
		if (Integer.parseInt(val.get("childCount")) > 0) {

			List<WebElement> cinput = driver.findElements(childInput);
			for (WebElement e : cinput) {
				if (e.getText().equalsIgnoreCase(val.get("childCount"))) {
					e.click();
				}
			}
		}

		if (Integer.parseInt(val.get("infantCount")) > 0) {

			List<WebElement> input = driver.findElements(infantInput);
			for (WebElement e : input) {
				if (e.getText().equalsIgnoreCase(val.get("infantCount"))) {
					e.click();
				}
			}
		}

		List<WebElement> input = driver.findElements(infantInput);
		for (WebElement e : input) {
			if (e.getText().equalsIgnoreCase(val.get("infantCount"))) {
				e.click();
			}
		}
		
		driver.findElement(applyButton).click();
		Reporter.log("Passengers are selected");
	}

	public void selectDate(String date, String tripType) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");

		Date dt = format.parse(date);

		String month = new SimpleDateFormat("MMMM").format(dt);
		String monthShort = new SimpleDateFormat("MMM").format(dt);
		String year = new SimpleDateFormat("yyyy").format(dt);
		String day = new SimpleDateFormat("dd").format(dt);
		String monthYearToBeSelected = month + year;

		if(tripType.equals("OneWay")) {
		 monthYearToBeSelected = month +" "+ year;
		}
		
		while (true) {
			String monthYrDisplayedLeft = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]"))
					.getText();
			String monthYrDisplayedRight = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[2]"))
					.getText();

			if (monthYrDisplayedLeft.equalsIgnoreCase(monthYearToBeSelected)
					|| monthYrDisplayedRight.equalsIgnoreCase(monthYearToBeSelected)) {
				driver.findElement(By.xpath("//div[contains(@aria-label,'" + monthShort + " " + day + "')]")).click();
				System.out.println(day);
				break;
			} else {
				driver.findElement(calNext).click();

			}
		}
		Reporter.log("Date is Selected");
	}

	public void sortPrice(String sortVal) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortPriceLabel));
		driver.findElement(sortPriceLabel).click();
		if(sortVal.equalsIgnoreCase("Cheapest")) {
			
			if(driver.findElements(sortPricedownArrow).size() <= 0) {
				driver.findElement(sortPriceUpArrow).click();
			}
			
		}
		Reporter.log("Price sorted to "+sortVal);
	}
	
	public void selectFlight() throws InterruptedException {
		Thread.sleep(10000);
		if(driver.findElements(viewFaresSelect).size() >= 0) {
		driver.findElement(viewFaresSelect).click();
		}

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewFaresBookNowButton));
		flightVal=getFlightDetails();

		Reporter.log("Book now is selected");
		driver.findElement(viewFaresBookNowButton).click();
	}
	public void selectRoundTripFlight() throws InterruptedException {
		Thread.sleep(5000);
		getOnwardVal=getOnwardFlightDetails();
		getReturnVal=getReturnFlightDetails();
		if(driver.findElements(viewFaresSelect).size() > 0) {
			driver.findElement(viewFaresSelect).click();
		}
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(bookNowButton));
		Reporter.log("Book now is selected");
		driver.findElement(bookNowButton).click();
	}
	
	public HashMap<String, String> getFlightDetails() {
		flightVal.put("AirPlaneName", driver.findElement(airplaneName).getText());
		flightVal.put("DepartureTime", driver.findElement(departTime).getText());
		flightVal.put("DeartureCity", driver.findElement(getDepartureCity).getText());
		flightVal.put("ArrivalCity", driver.findElement(getArrivalCity).getText());
		return flightVal;
	}
	
	public HashMap<String, String> getOnwardFlightDetails() {
		getOnwardVal.put("AirPlaneName", driver.findElement(roundAirplaneName).getText());
		getOnwardVal.put("DepartureTime", driver.findElement(roundDepartTime).getText());
		getOnwardVal.put("DeartureCity", driver.findElement(getRoundDepartureCity).getText());
		getOnwardVal.put("ArrivalCity", driver.findElement(getRoundArrivalCity).getText());
		return getOnwardVal;
	}
	public HashMap<String, String> getReturnFlightDetails() {
		getReturnVal.put("DepartureTime", driver.findElement(returnDepartTime).getText());
		getReturnVal.put("DeartureCity", driver.findElement(returnDepartCity).getText());
		getReturnVal.put("ArrivalCity", driver.findElement(returnArriveCity).getText());
		return getReturnVal;
	}
	public HashMap<String, String> getSelectedFlightDetails() {
		getflightVal.put("AirPlaneName", driver.findElement(selectedAirplanename).getText());
		getflightVal.put("DepartureTime", driver.findElement(selectedDepartTime).getText());
		getflightVal.put("DeartureCity", driver.findElement(selectedDepartureCity).getText());
		getflightVal.put("ArrivalCity", getArrivalCity());
		return getflightVal;
	}
	public HashMap<String, String> getSelectedOnwardFlightDetails() {
		getSelectOnwardVal.put("AirPlaneName", driver.findElement(selectedAirplanename).getText());
		getSelectOnwardVal.put("DepartureTime", driver.findElement(selectedDepartTime).getText());
		getSelectOnwardVal.put("DeartureCity", driver.findElement(selectedDepartureCity).getText());
		getSelectOnwardVal.put("ArrivalCity", getArrivalCity());
		return getflightVal;
	}
	public HashMap<String, String> getSelectedReturnFlightDetails() {
		getSelectReturnVal.put("AirPlaneName", driver.findElement(selectedAirplanename).getText());
		getSelectReturnVal.put("DepartureTime", driver.findElement(selectReturnDepartTime).getText());
		getSelectReturnVal.put("DeartureCity", driver.findElement(selectReturnDepartCity).getText());
		getSelectReturnVal.put("ArrivalCity", driver.findElement(selectReturnArriveCity).getText());
		return getSelectReturnVal;
	}
	
	public void verifyFlightDetails() {
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
			getflightVal=getSelectedFlightDetails();
	
		Assert.assertEquals(flightVal.get("AirPlaneName"), getflightVal.get("AirPlaneName"));
		Assert.assertEquals(flightVal.get("DepartureTime"), getflightVal.get("DepartureTime"));
		Assert.assertEquals(flightVal.get("DeartureCity"), getflightVal.get("DeartureCity"));
		Assert.assertEquals(flightVal.get("ArrivalCity"), getflightVal.get("ArrivalCity"));
		
	}
	public void verifyRoundTripFlightDetails() {
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
			getSelectedOnwardFlightDetails();
			getSelectedReturnFlightDetails();
			Assert.assertEquals(getOnwardVal.get("AirPlaneName"), getSelectOnwardVal.get("AirPlaneName"));
			Assert.assertEquals(getOnwardVal.get("DepartureTime"), getSelectOnwardVal.get("DepartureTime"));
			Assert.assertEquals(getOnwardVal.get("DeartureCity"), getSelectOnwardVal.get("DeartureCity"));
			Assert.assertEquals(getOnwardVal.get("ArrivalCity"), getSelectOnwardVal.get("ArrivalCity"));
			Assert.assertEquals(getReturnVal.get("DepartureTime"), getSelectReturnVal.get("DepartureTime"));
			Assert.assertEquals(getReturnVal.get("DeartureCity"), getSelectReturnVal.get("DeartureCity"));
			Assert.assertEquals(getReturnVal.get("ArrivalCity"), getSelectReturnVal.get("ArrivalCity"));
			
	}
	
	public void sortRoundTripPrice() {
		driver.findElement(sortOnwardPrice).click();
		driver.findElement(selectOnwardLowPrice).click();
		Reporter.log("Onward Price sorted ");
		driver.findElement(sortReturnPrice).click();
		driver.findElement(selectReturnLowPrice).click();
		Reporter.log("Return Price sorted ");
	}
}
