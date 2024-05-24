package testcases_CURA;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage_Cura;
import test_base.Base_Setup_proj;
import test_base.CustomListener;
import util.Test_Util;

@Listeners(CustomListener.class)
public class TC_homepage extends Base_Setup_proj{
	
	HomePage_Cura homepage;
	Test_Util testutil;

	
	@BeforeMethod
	public void setup() throws IOException {
		intilization();
		homepage = new HomePage_Cura();
			
	}
	
	@Test
	
    public void hp_verify()
    {
		
    	String title = homepage.homepage_title_verification();
    	String subtitle = homepage.hp_subtitle_verification();
    	Assert.assertEquals(title, "CURA Healthcare Service1");
    	System.out.println("validation passed for title ");
    	Assert.assertEquals(subtitle, "We Care About Your Health");
    	System.out.println("validation passed for Sub title ");
    }
    
    @Test
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
