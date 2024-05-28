package testcases_CURA;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pages.HomePage_Cura;
import test_base.Base_Setup_proj;

public class TC_homepage extends Base_Setup_proj{
	
	HomePage_Cura homepage;


	
	@BeforeMethod
	public void setup() throws IOException {
		intilization();
		homepage = new HomePage_Cura();
			
	}
	
	@Test(priority=2)
	
    public void hp_verify()
    {
		
    	String title = homepage.homepage_title_verification();
    	String subtitle = homepage.hp_subtitle_verification();
    	Assert.assertEquals(title, "CURA Healthcare Service");
    	System.out.println("validation passed for title ");
    	Assert.assertEquals(subtitle, "We Care About Your Health-9999999"); 
    	log.info("validation passed for Sub title ");
    	System.out.println("validation passed for Sub title ");
    }
    
    @Test(priority=1)
    public void hp_button_verify()
    {
    	homepage.hp_makeappointment_verify();
    }
    
    @AfterMethod
    public void close()
    {
    	driver.close();
    }
}
