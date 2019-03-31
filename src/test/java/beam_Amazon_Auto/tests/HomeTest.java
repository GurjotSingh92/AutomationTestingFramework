package beam_Amazon_Auto.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import beam_Amazon_Auto.utils.ExtentTestManager;
import beam_Amazon_Auto.utils.Utilities;

public class HomeTest extends BaseTest {

	private String itemTextTD;

	@BeforeClass(alwaysRun = true)
	private void setup() {
		itemTextTD = Utilities.getValue(pageContent, "itemToSearch");
	}

	@Test(priority = 1)
	public void searchAndVerifyList() throws IOException, InterruptedException {
		ExtentTestManager.getTest().setDescription("Search for any product and verify the list");
		int sizeOfEle=homePg.searchForTheItem(itemTextTD);
		if(sizeOfEle<1) {
			throw new AssertionError();
		}
	}
	
	@Test(priority=1)
	public void amazonPayViewStatement() {
		ExtentTestManager.getTest().setDescription("Under Amazo Pay, view the account statement");
		if(!homePg.amazonPayViewStment()) {
			throw new AssertionError();
		}
	}

}
