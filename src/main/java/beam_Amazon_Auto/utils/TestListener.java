package beam_Amazon_Auto.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import beam_Amazon_Auto.utils.helpers.WebDriverManager;

public class TestListener implements ITestListener{

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("I am in onTestStart method " +  getTestMethodName(result) + " start");
		ExtentTestManager.startTest(getTestMethodName(result), "");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("I am in onTestSuccess method " +  getTestMethodName(result) + " succeed");	
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("I am in onTestFailure method " +  getTestMethodName(result) + " failed");	
		//Object testClass = result.getInstance();
		WebDriver webDriver = WebDriverManager.getDriver("chrome");
		String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);
		ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped");		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub		
	}

}
