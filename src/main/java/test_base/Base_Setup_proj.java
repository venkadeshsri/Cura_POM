package test_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Setup_proj {
	
	public static WebDriver driver;
    public static Properties prop;
    public static final Logger log= LogManager.getLogger(Base_Setup_proj.class);

public void intilization() throws IOException
   {
		prop = new Properties();
		File file = new File("D:\\ECLIPSE - Automation\\Automation-Selenium\\Cura_POM\\src\\main\\java\\config\\config_CURA");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		
	   String browsername = prop.getProperty("browser");
	   String url = prop.getProperty("url");
	   if (browsername.equalsIgnoreCase("Chrome"))
		{			
		   ChromeOptions options = new ChromeOptions();
		   driver = WebDriverManager.chromedriver().create();
		   options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			
		} else if(browsername.equalsIgnoreCase("firefox")) {
		
			driver = new FirefoxDriver();
		} else
		{
			System.out.println("Browser not found");
		}
	   
	   
	   driver.manage().window().maximize();
	   driver.get(url);
	   
	 
	
	   
   }

/*
public void failed() throws IOException
{
	try {
	File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcfile, new File("D:\\ECLIPSE - Automation\\Automation-Selenium\\Cura_POM\\screenshots\\" +
	"Failed Screen_"+ System.currentTimeMillis()+"_" +".jpg" ));
	
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	// return null;
	
	

}	*/

public void logger()
{
	log.info("info log message");
	log.warn("Hey this just a warning message");
	log.fatal("hey this is just fatal error message");
	log.debug("this is debug message");
}
}
