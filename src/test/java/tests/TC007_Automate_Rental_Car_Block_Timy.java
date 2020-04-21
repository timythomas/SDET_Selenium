package tests;

import java.util.HashMap;
import common.*;


import org.testng.Assert;
import org.testng.annotations.Test;


import pages.DemoQASitePages.ControlGroupPage;

public class TC007_Automate_Rental_Car_Block_Timy extends BaseClass {

	@Test
	public void clickAndPrintItem() throws InterruptedException {
		driver.get("https://demoqa.com/controlgroup/");
		Assert.assertEquals(ControlGroupPage.verifyHeader(), "Controlgroup");
		HashMap<String,String> rentalVal=new HashMap<String, String>();
		rentalVal.put("carType", "SUV");
		rentalVal.put("standardType", "true");
		rentalVal.put("automaticType", "false");
		rentalVal.put("insuranceType", "true");
		rentalVal.put("carNumbers", "-5");
		
		ControlGroupPage.RentalCarBook_Horz(rentalVal);
		ControlGroupPage.RentalCarBook_vert(rentalVal);
		Thread.sleep(5000);
	}
}
