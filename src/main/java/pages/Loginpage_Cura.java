package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test_base.Base_Setup_proj;

public class Loginpage_Cura extends Base_Setup_proj{
	
	@FindBy(xpath="//h2[normalize-space()='Login']") WebElement log_title;
	@FindBy(xpath="//p[@class='lead']") WebElement log_subtitle;
	@FindBy(xpath="//label[normalize-space()='Username']") WebElement label_usrname;
	@FindBy(xpath="//label[normalize-space()='Password']") WebElement label_pwd;
    @FindBy(xpath="//input[@id='txt-username']") WebElement usrname;
    @FindBy(xpath="//input[@id='txt-password']") WebElement passwd;
    @FindBy(xpath="//button[@id='btn-login']") WebElement login_btn;
    
    public Loginpage_Cura()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public String log_title_txt_verify()
    {
    	System.out.println(log_title.getText());
    	log.info("Login page title : " + log_title.getText());
    	return log_title.getText();
    	
    }
    
    public String log_subtitle_txt_verify()
    {
    	System.out.println(log_subtitle.getText());
    	log.info("Login page subtitle : " + log_subtitle.getText());
    	return log_title.getText();
    
    }
    
    public Make_Appointment_Cura login_verify(String un,String pwd)
    {
     	usrname.sendKeys(un);
     	passwd.sendKeys(pwd);
     	log.info("entered username is :" + usrname.getAttribute("value"));
    	login_btn.click();
     	return new Make_Appointment_Cura();
    }
}
