package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import test_base.Base_Setup_proj;

public class Test_Util extends Base_Setup_proj{
	
	public void failed() throws IOException
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentdir = System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File("D:\\ECLIPSE - Automation\\Automation-Selenium\\Cura_POM\\screenshots" + "Failed Screen_"+ System.currentTimeMillis()+"_" +".jpg" ));
		//FileUtils.copyFile(srcfile, new File("/Cura_POM/Screenshots"+ "Failed Screen_"+ System.currentTimeMillis()+"_" +".jpg" ));
	}

}
