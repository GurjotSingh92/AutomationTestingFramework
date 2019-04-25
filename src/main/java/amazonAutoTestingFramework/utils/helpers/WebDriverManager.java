package amazonAutoTestingFramework.utils.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Singleton class to maintain single instance driver all over the project
 */
public class WebDriverManager {
	public static WebDriver driver;
	static String USER_DIR=System.getProperty("user.dir");
	
	//returns single instance of driver
	public static WebDriver getDriver(String browserName) {
		if (driver == null) {
			switch (browserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", USER_DIR + "/drivers/chromedriver");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.chrome.driver", USER_DIR + "/drivers/geckodriver");
				driver = new FirefoxDriver();
				break;
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	//gets the url
	public static void getURL(String browser,String url) {
		getDriver(browser).get(url);
	}

}
