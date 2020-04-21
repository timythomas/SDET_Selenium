package tests;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.testng.annotations.Test;

import pages.OlaySitePages.LoginPage;
import pages.OlaySitePages.RegisterPage;
import common.*;

public class TC008_Olay_Registration_Login_Timy extends BaseClass {
	@Test
	public void RegisterAndLoginUK() throws InterruptedException, ParseException, IOException {
		LoginPage.loginLanguage("OlayUK");
		HashMap<String,String> regVals= new HashMap<String, String>();
		regVals.put("EmailAddress", "tia@gmail.com");
		regVals.put("Password", "Wipro@123");
		regVals.put("Birthday", "11-Mar-1996");
		HashMap<String,String> regFinalVals=RegisterPage.registerValuesUK(regVals);
		RegisterPage.userRegister(regFinalVals,"UK");
		LoginPage.logout();
		LoginPage.userLogin(regFinalVals,"UK");
		LoginPage.logout();

	} 
	@Test
	public void RegisterAndLoginGermany() throws InterruptedException, ParseException, IOException {
		LoginPage.loginLanguage("OlayGermany");		
		HashMap<String,String> regFinalVals=RegisterPage.registerValuesGermany();	
		RegisterPage.userRegister(regFinalVals,"Germany");
		LoginPage.logout();
		LoginPage.userLogin(regFinalVals,"Germany");
		LoginPage.logout();
		
	}
	@Test
	public void RegisterAndLoginSpain() throws InterruptedException, ParseException, IOException, org.json.simple.parser.ParseException {
		LoginPage.loginLanguage("OlaySpain");		
		HashMap<String,String> regFinalVals=RegisterPage.registerValuesSpanish();	
		RegisterPage.userRegister(regFinalVals,"Spain");
		LoginPage.userLogin(regFinalVals,"Spain");
		LoginPage.logout();
		
	}
	@Test
	public void inValidLogin() throws InterruptedException, ParseException, IOException, org.json.simple.parser.ParseException {
		LoginPage.loginLanguage("OlayUK");
		HashMap<String,String> regVals= new HashMap<String, String>();
		regVals.put("EmailAddress", "tia12@gmail.com");
		regVals.put("Password", "Wipro@123");
		LoginPage.userLogin(regVals,"UK");
		LoginPage.verifyInvalidLogin("The email and password combination you entered is incorrect. Please try again, or click the link below to create an account.");
	}
	
	@Test
	public void verifyForgotPassword() throws InterruptedException, ParseException, IOException, org.json.simple.parser.ParseException {
		LoginPage.loginLanguage("OlayUK");
		HashMap<String,String> regVals= new HashMap<String, String>();
		regVals.put("EmailAddress", "ria@gmail.com");
		LoginPage.verifyforgotPwd(regVals, "We have sent an email to your email address,");
	}
}
