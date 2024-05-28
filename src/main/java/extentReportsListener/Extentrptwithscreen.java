package extentReportsListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import test_base.Base_Setup_proj;
import util.ExtentReporter;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Extentrptwithscreen extends Base_Setup_proj  implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {

		extentReport = ExtentReporter.generateExtentRpts(); // ExtentReporter.java from util

	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + "- Test Started ");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS, testName + "- Test Passed ");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();

		//WebDriver driver = null;
	/*	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance()); // using result --will retrive the driver otherwise it will display
												// error
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String destPath = System.getProperty("user.dir" + "\\screenshots\\" + testName + System.currentTimeMillis() + ".jpg");
		String destPath = ("D:\\ECLIPSE - Automation\\Automation-Selenium\\Cura_POM\\screenshots" + testName + System.currentTimeMillis() + ".jpg");

		/*	try {
			FileUtils.copyFile(srcfile, new File(destPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		try {
			FileHandler.copy(srcfile, new File(destPath)); 
		} catch (IOException e) {

			e.printStackTrace();
		} 

		extentTest.addScreenCaptureFromPath(destPath);
		extentTest.log(Status.INFO, result.getThrowable());		
		extentTest.log(Status.FAIL, testName + "- Test Failed");

        }

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());		
		extentTest.log(Status.FAIL, testName + "- Test Skipped");
			
	}

	@Override
	public void onFinish(ITestContext context) {

	extentReport.flush();
	}

}
