package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentRpts()
	{
		ExtentReports extentrpt = new ExtentReports();
		File extentrptfile = new File ("D:\\ECLIPSE - Automation\\Automation-Selenium\\Cura_POM\\src\\main\\java\\Extent-Report\\extentReport.html");
		ExtentSparkReporter sparkrpt = new ExtentSparkReporter(extentrptfile);
		sparkrpt.config().setTheme(Theme.DARK);
		sparkrpt.config().setReportName("CURA_REPORT");
		sparkrpt.config().setDocumentTitle("CURA_Report_VENKAT");
		sparkrpt.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
		
		extentrpt.attachReporter(sparkrpt);
		
		Properties extent_prop = new Properties();
		File file = new File("D:\\ECLIPSE - Automation\\Automation-Selenium\\Cura_POM\\src\\main\\java\\config\\config_CURA");
		try {
			
		FileInputStream fis = new FileInputStream(file);
		extent_prop.load(fis);
		
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		extentrpt.setSystemInfo("Test URL : ", extent_prop.getProperty("url"));
		extentrpt.setSystemInfo("Browser name : ", extent_prop.getProperty("browser"));
		extentrpt.setSystemInfo("Tested User name : ", extent_prop.getProperty("username"));
		extentrpt.setSystemInfo("OS name : ", System.getProperty("os.name"));
		extentrpt.setSystemInfo("User Name : ", System.getProperty("user.name"));
		extentrpt.setSystemInfo("Java Version : ", System.getProperty("java.version"));
		
		
		return extentrpt;
		
		
		
	}

}
