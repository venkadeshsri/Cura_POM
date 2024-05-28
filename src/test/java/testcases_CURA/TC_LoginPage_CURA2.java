package testcases_CURA;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage_Cura;
import pages.Loginpage_Cura;
import pages.Make_Appointment_Cura;
import test_base.Base_Setup_proj;




public class TC_LoginPage_CURA2 extends Base_Setup_proj {
	
    HomePage_Cura homepage;
    Loginpage_Cura loginpage;
    Make_Appointment_Cura makeappointment;
  


	@BeforeMethod
	public void setup() throws IOException {
		intilization();
		homepage = new HomePage_Cura();
		loginpage = new Loginpage_Cura();
		homepage.hp_makeappointment_verify();
			
	}
	
	@Test
	public void logintest()
	{
		makeappointment = loginpage.login_verify(prop.getProperty("username"), prop.getProperty("password"));
	}
	
    @AfterMethod
    public void close()
    {
    	driver.close();
    }
}
