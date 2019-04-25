package amazonAutoTestingFramework.pageObjects;

import java.util.Properties;

import amazonAutoTestingFramework.utils.Utilities;
import amazonAutoTestingFramework.utils.helpers.CustomWrappers;
import org.openqa.selenium.By;

/*
 * All the re-usable objects,variables,locators will be kept in this class since this class is being extended in all the other page files
 */
public class BasePage {
	//list of all re-usable objects
	Utilities utility = new Utilities();
	CustomWrappers custom=new CustomWrappers();
	protected static Properties pageContent;
	
	//list of all reusable locators
	protected By searchBar = utility.getLocator("searchBar");
	protected By submitBtn = utility.getLocator("searchSubmitBtn");
	protected String url=Utilities.getValue(pageContent, "url_home");
	
	static {
		Utilities utility = new Utilities();
		pageContent=utility.loadPropertiesFile(Utilities.FilePath.testDataFile);
	}
	
	


}
