package beam_Amazon_Auto.tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import beam_Amazon_Auto.pageObjects.HomePage;
import beam_Amazon_Auto.pageObjects.LoginPage;
import beam_Amazon_Auto.utils.ExtentManager;
import beam_Amazon_Auto.utils.ExtentTestManager;
import beam_Amazon_Auto.utils.Utilities;
import beam_Amazon_Auto.utils.Utilities.FilePath;
import beam_Amazon_Auto.utils.helpers.WebDriverManager;

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
		ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
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
