package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test_base.Base_Setup_proj;

public class HomePage_Cura extends Base_Setup_proj{
	
	@FindBy(xpath="//h1[normalize-space()='CURA Healthcare Service']") WebElement title;
	@FindBy(xpath="//h3[normalize-space()='We Care About Your Health']") WebElement subtitle;
	@FindBy(xpath="//a[@id='btn-make-appointment']") WebElement make_appoint_btn;
	@FindBy(xpath="//a[@id='menu-toggle']") WebElement menu;
	
	public HomePage_Cura()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String homepage_title_verification()
	{
		System.out.println(title.getText());
	log.info("title is : " + title.getText());
		return title.getText();
				
	}
	
	public String hp_subtitle_verification()
	{
		System.out.println(subtitle.isDisplayed());
		log.info("Is subtitle is displayed : " + subtitle.isDisplayed());
		return subtitle.getText();
	}
    public Loginpage_Cura hp_makeappointment_verify()
    {
    	System.out.println("Menu displayed :" + menu.isDisplayed());
    	log.info("Menu displayed :" + menu.isDisplayed());
    	System.out.println("Menu Enabled :" + menu.isEnabled());
    	log.info("Menu Enabled :" + menu.isEnabled());
    	menu.click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	make_appoint_btn.click();
    	return new Loginpage_Cura();
    }
}
