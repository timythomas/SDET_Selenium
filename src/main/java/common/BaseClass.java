package common;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	
	@BeforeTest
	@Parameters("browserType")
	public void setup(String browser) throws Exception{
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\util\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\util\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}		
	public static String getProperty(String key) throws IOException {
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\util\\AUT.properties";
	InputStream input = null;
	Properties prop = new Properties();
    input = new FileInputStream(new File(filePath));
 	prop.load(input);
	return prop.getProperty(key);
        
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
