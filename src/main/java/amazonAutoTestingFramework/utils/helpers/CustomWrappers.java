package amazonAutoTestingFramework.utils.helpers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.google.common.collect.Sets;


/**
 * @author Gurjot Ahuja All the common functions related to the app are kept in
 *         this class. The methods in this class are framework independent and
 *         can be re-used in any framework
 */

public class CustomWrappers {

	
	
	private static WebDriver driver = WebDriverManager.getDriver("chrome");
	private static String FOLDER_NAME;
	private static String USER_DIR = System.getProperty("user.dir");

	// wait till element appears
	public static void waitForVisible(By by, int t) {
		WebDriverWait wait = new WebDriverWait(driver, t);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}

	// returns size of elements
	public static int sizeOfEle(By by, int wait) throws InterruptedException {
		Thread.sleep(wait);
		return driver.findElements(by).size();
	}

	// mouse hover and click
	public static void mouseHover(By moveToElement, By submenu) {
		Actions actions = new Actions(driver);
		WebElement ele = driver.findElement(moveToElement);
		
		actions.moveToElement(ele);
		WebElement subMenu = driver.findElement(submenu);
		actions.moveToElement(subMenu);
		actions.click().build().perform();
	}

	// get number of iframes in a page
	public static List<WebElement> findIframes(int index) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer.parseInt(exe.executeScript("return window.length").toString());
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		return iframeElements;

	}

	// sikuli initialization
	public static void sikuli_init(String itemName) throws FindFailed {
		String inputFilePath = System.getProperty("user.dir") + "/sikuli_images/";
		Screen s = new Screen();
		Pattern item = new Pattern(inputFilePath + itemName);
		s.wait(item, 20);
		s.click(item);
	}

	public static void sikuli_init(String itemName, String clickStatus) throws FindFailed {
		String inputFilePath = System.getProperty("user.dir") + "/sikuli_images/";
		Screen s = new Screen();
		Pattern item = new Pattern(inputFilePath + itemName);
		s.wait(item, 20);
	}

	// sikuli initialization
	public static void sikuli_init_2(String itemName) throws FindFailed {
		String inputFilePath = System.getProperty("user.dir") + "/sikuli_images/";
		Screen s = new Screen();
		Pattern item = new Pattern(inputFilePath + itemName);
		s.wait(item, 20);
		s.click(item);
		s.click(item);
	}

	// clear text
	public static void clearText(By by, int wait) {
		waitForVisible(by, wait);
		driver.findElement(by).clear();
	}

	// returns boolean val - element is there or not
	public static boolean isElementDisplayed(By by, int wait) {
		try {
			waitForVisible(by, wait);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// wait before click
	public static void customClick(By by, int wait) {
		waitForVisible(by, wait);
		driver.findElement(by).click();
	}

	// get Element Text
	public static String getElementText(By by, int wait) {
		waitForVisible(by, wait);
		return driver.findElement(by).getText();
	}

	public static List<String> getStringListFromArray(String[] str) {
		List<String> textEle = new ArrayList<>();
		for (String stringEle : str) {
			textEle.add(stringEle);
		}
		return textEle;
	}

	// compare or assert 2 lists
	public static boolean compare2Lists(List<String> list1, List<String> list2) {

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).equals(list2.get(i))) {
				return true;
			}
		}

		return false;

	}

	// get all the elements and store it in a list
	public static List<String> getAllElementsText(By by) {
		waitForVisible(by, 20);
		List<WebElement> webElements = getAllElements(by);
		List<String> textList = new ArrayList<>();
		for (WebElement ele : webElements)
			textList.add(ele.getText());
		return textList;
	}

	// method to verify back button and next page displayed
	public static boolean navBackUntilleleFound(By backButtonEle, By eletoVerify) {
		boolean exp_val = isElementDisplayed(eletoVerify, 10);
		int i = 0;
		while (exp_val == false && i < 5) {
			customClick(backButtonEle, 10);
			exp_val = isElementDisplayed(eletoVerify, 10);
			if (exp_val == true) {
				return true;
			}
			i++;
		}
		exp_val = isElementDisplayed(eletoVerify, 10);
		if (exp_val == false) {
			return false;
		}
		return false;
	}

	// method to perform any action till expected element appears
	public static boolean performActionUntilleleFound(By btnToPerform, By eletoVerify) {
		boolean exp_val = isElementDisplayed(eletoVerify, 10);
		int i = 0;
		while (exp_val == false && i < 5) {
			customClick(btnToPerform, 10);
			exp_val = isElementDisplayed(eletoVerify, 10);
			if (exp_val == true) {
				return true;
			}
			i++;
		}
		exp_val = isElementDisplayed(eletoVerify, 10);
		if (exp_val == false) {
			return false;
		}
		return false;
	}

	// this method is replica of above method but with different args
	public static void waitAndEnterText(By by, String text, int wait) {
		waitForVisible(by, wait);
		driver.findElement(by).sendKeys(text);
	}

	// this method takes screenshot on failure
	public static String takeScreenShotOnFailure() {
		try {
			File snapshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String dateNow = getCurrentDate();
			String snapShotDirectory = USER_DIR + "/Snaphots/" + FOLDER_NAME;
			String location = snapShotDirectory + "/failure_screenshot_" + dateNow + ".png";
			File file = new File(location);
			FileUtils.copyFile(snapshot, file);
			return file.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// this method will get the current local time
	public static String getCurrentDate() {
		String DATE_FORMAT_NOW = "yyyy/MMM/dd";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		FOLDER_NAME = sdf.format(date).replace("/", "_");
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
		return formatter.format(currentDate.getTime()).replace("/", "_").replace(":", "_").replace(" ", "");
	}

	// get all the elements in a set
	public static Set<String> getAllElementsTextSet(By by) {
		waitForVisible(by, 20);
		List<WebElement> webElements = getAllElements(by);
		Set<String> textList = new HashSet<String>();
		for (WebElement ele : webElements)
			textList.add(ele.getText());
		return textList;
	}

	// gets all the elements by element attribute
	public static List<WebElement> getAllElements(By by) {
		return driver.findElements(by);
	}

	// this method will scroll down until last page and get the list of all the
	// elements till end
	public Set<String> scrollDownAndGetListOfAllElementsTillEnd(By by) throws IOException, InterruptedException {
		int count = 15;
		Set<String> new_set;
		Set<String> temp = getAllElementsTextSet(by);
		for (int i = 0; i < count; i++) {
			Set<String> currentSet = getAllElementsTextSet(by);
			Set<String> union = Sets.union(temp, currentSet);
			scrollInPage("up");
			Thread.sleep(3000); //intentional sleep for list to get load
			new_set = getAllElementsTextSet(by);
			if (compare2sets(new_set, currentSet)) {
				return union;
			}
		}
		return null;
	}

	// compare 2 sets
	public static boolean compare2sets(Set<?> set1, Set<?> set2) {
		if (set1 == null || set2 == null) {
			return false;
		}
		if (set1.size() != set2.size()) {
			return false;
		}
		return set1.containsAll(set2);
	}

	// scroll in the page : up/down
	public static void scrollInPage(String direction) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (direction.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollBy(0,1000)");
		} else {
			js.executeScript("window.scrollBy(1000,0)");
		}
	}

}
