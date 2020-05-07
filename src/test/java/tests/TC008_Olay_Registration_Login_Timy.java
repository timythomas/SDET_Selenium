package tests;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.OlaySitePages.LoginPage;
import pages.OlaySitePages.RegisterPage;
import common.*;

public class TC008_Olay_Registration_Login_Timy extends BaseClass {
	
	@Test
	@Parameters("country")
	public void RegisterAndLoginUK(String country) throws InterruptedException, ParseException, IOException, org.json.simple.parser.ParseException {
		LoginPage.loginLanguage(country);
		HashMap<String,String> regVals=RegisterPage.userRegister(country);
		LoginPage.logout();
		LoginPage.userLogin(regVals,country);
		LoginPage.logout();

	}	
	@Test
	@Parameters("country")
	public void inValidLogin(String country) throws InterruptedException, ParseException, IOException, org.json.simple.parser.ParseException {
		LoginPage.loginLanguage(country);
		HashMap<String,String> regVals= new HashMap<String, String>();
		regVals.put("EmailAddress", "tia12@gmail.com");
		regVals.put("Password", "Wipro@123");
		LoginPage.userLogin(regVals,country);
		Thread.sleep(5000);
		LoginPage.verifyInvalidLogin(country);
	}
	
	@Test
	@Parameters("country")
	public void verifyForgotPassword(String country) throws InterruptedException, ParseException, IOException, org.json.simple.parser.ParseException {
		LoginPage.loginLanguage(country);
		HashMap<String,String> regVals= new HashMap<String, String>();
		regVals.put("EmailAddress", "ria@gmail.com");
		LoginPage.verifyforgotPwd(regVals,country );
	}
}
