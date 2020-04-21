package tests;

import java.text.ParseException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import common.BaseClass;
import pages.DemoQASitePages.MakeMyTripPages.HomePage;

public class TC009_BookOneWayFlight_UsingMakeMytrip_Timy extends BaseClass{
	@Test
	public void bookFlightsOneWay() throws InterruptedException, ParseException {
		driver.get("https://www.makemytrip.com/");
		HomePage homePg = new HomePage(driver);
		HashMap<String,String> bookTicket= new HashMap<String, String>();
		bookTicket.put("FromCity", "Chennai,");
		bookTicket.put("ToCity", "Bangkok,");
		bookTicket.put("DepartureDate", "11-Mar-21");
		bookTicket.put("adultCount", "2");
		bookTicket.put("childCount", "1");
		bookTicket.put("infantCount", "1");
		bookTicket.put("travellingReason", "Leisure");
		homePg.oneWayTrip(bookTicket);
		homePg.verifyFlightDetails();
	
	}
	@Test
	public void bookFlightsRoundTrip() throws InterruptedException, ParseException {
		driver.get("https://www.makemytrip.com/");
		HomePage homePg = new HomePage(driver);
		HashMap<String,String> bookTicket= new HashMap<String, String>();
		bookTicket.put("FromCity", "Chennai,");
		bookTicket.put("ToCity", "Bangkok,");
		bookTicket.put("DepartureDate", "13-Mar-21");
		bookTicket.put("ReturnDate", "15-Mar-21");
		bookTicket.put("adultCount", "2");
		bookTicket.put("childCount", "1");
		bookTicket.put("infantCount", "1");
		bookTicket.put("travellingReason", "Leisure");
		homePg.roundTrip(bookTicket);
		homePg.verifyRoundTripFlightDetails();
	
	}
	
}
