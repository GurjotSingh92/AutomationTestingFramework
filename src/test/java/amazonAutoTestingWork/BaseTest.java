package amazonAutoTestingWork;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import amazonAutoTestingFramework.pageObjects.HomePage;
import amazonAutoTestingFramework.pageObjects.LoginPage;
import amazonAutoTestingFramework.utils.ExtentTestManager;
import amazonAutoTestingFramework.utils.Utilities;
import amazonAutoTestingFramework.utils.Utilities.FilePath;
import amazonAutoTestingFramework.utils.helpers.WebDriverManager;

public class BaseTest {
	Utilities utility=new Utilities();
	HomePage homePg=new HomePage();
	LoginPage loginPg=new LoginPage();
	protected static Properties pageContent;
	private String browserName;
	protected String url;
	private String phoneNumber;
	
	@BeforeSuite(alwaysRun = true)
	public void initialization() {
		pageContent=utility.loadPropertiesFile(FilePath.testDataFile);
		browserName = Utilities.getValue(pageContent, "browser");
		url=Utilities.getValue(pageContent, "url");
		phoneNumber=Utilities.getValue(pageContent, "phoneNumber");	
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		ExtentTestManager.endExtentTest();
        ExtentTestManager.ExtentManager.getReporter().flush();
	}
	
	@BeforeTest(alwaysRun = true)
	public void driverSetup() {
		WebDriverManager.getDriver(browserName);
		WebDriverManager.getURL(browserName, url);
		loginPg.enterLoginDetails(phoneNumber, phoneNumber);
		clearCart();
	}
	
	@AfterTest
	public void tearDown() {
		WebDriver driver=WebDriverManager.getDriver(browserName);
		driver.quit();
	}
	
	//this method will clear the cart after login at every new driver session
	public void clearCart() {
		homePg.clearCartItems();
	}

}
