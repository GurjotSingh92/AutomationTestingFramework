package amazonAutoTestingFramework.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


import org.openqa.selenium.By;




/*
 * Contains all the configuration utilities used in the framework. 
 * Advantage of using this file is that we can import it in any framework and have code re-usablitiy
 */
public class Utilities {
	private Properties prop;
	private InputStream input;
	private static String USER_DIR = System.getProperty("user.dir");
	public static Properties testData;
	public static Properties testLocators;
	public String locatorValue;
	public Properties locators = loadPropertiesFile(FilePath.testLocatorsFile);
	
	
	
	
	//gets the value of testdata
	public static String getValue(Properties prop, String propKey) {
		try {
			return prop.getProperty(propKey).trim();
		} catch (NullPointerException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	//get the value of locator
	public By getLocator(String locatorKey) {
		try {
			By locator = null;
			locatorValue = Utilities.getValue(locators, locatorKey);
			if (locatorValue.startsWith("name_"))
				locator = By.name(locatorValue.replaceFirst("name_", ""));
			else if (locatorValue.startsWith("xpath_"))
				locator = By.xpath(locatorValue.replaceFirst("xpath_", ""));
			else if (locatorValue.startsWith("id_"))
				locator = By.id(locatorValue.replaceFirst("id_", ""));
			else if (locatorValue.startsWith("classname_"))
				locator = By.className(locatorValue.replaceFirst("classname_", ""));
			return locator;
		} catch(Exception err) {
			err.printStackTrace();
			return null;
		}	
	}
	
		
	
	//to set the file path
	public enum FilePath {
		testDataFile(USER_DIR + "/src/main/java/beam_Amazon_Auto/dataSources/testData.properties"),
		testLocatorsFile(USER_DIR + "/src/main/java/beam_Amazon_Auto/dataSources/testLocators.properties");
		FilePath(String path) {
			this.relativePath = path;
		}
		public String relativePath;
	}

	// To read content from properties file.
	public Properties loadPropertiesFile(FilePath path) {
		try {
			prop = new Properties();
			input = new FileInputStream(path.relativePath);
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return prop;
	}
	
}
