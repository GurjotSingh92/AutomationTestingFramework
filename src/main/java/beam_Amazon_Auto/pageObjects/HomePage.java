package beam_Amazon_Auto.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import beam_Amazon_Auto.utils.helpers.CustomWrappers;
import beam_Amazon_Auto.utils.helpers.WebDriverManager;


public class HomePage extends BasePage{
	private By searchItem=utility.getLocator("searchItems");
	private By amzonPay=utility.getLocator("amazonPayTab");
	private By viewStatement=utility.getLocator("viewStatement");
	private By viewStmntHeading=utility.getLocator("viewStatementHeading");
	private By cartBtn=utility.getLocator("navCart");
	private By delteBtn=utility.getLocator("deleteBtnCart");
	private By emptySubTotal=utility.getLocator("subtotal_empty");
	private By emptyCartTxt=utility.getLocator("emptyCartTxt");

	// Search for a product. Verify the list.
	public int searchForTheItem(String item) throws IOException, InterruptedException {
		WebDriverManager.getURL("chrome", url);
		CustomWrappers.waitAndEnterText(searchBar, item, 10);
		CustomWrappers.customClick(submitBtn, 10);
		return CustomWrappers.getAllElementsText(searchItem).size();
	}
	
	//view amazon pay statement
		public boolean amazonPayViewStment() {
			WebDriverManager.getURL("chrome", url);
			CustomWrappers.customClick(amzonPay, 10);
			CustomWrappers.customClick(viewStatement, 10);
			return CustomWrappers.isElementDisplayed(viewStmntHeading, 10);
		}
		
		//clear cart items
		public void clearCartItems() {
			CustomWrappers.customClick(cartBtn, 10);
			if(CustomWrappers.isElementDisplayed(emptyCartTxt, 20)) {
				return;
			}
			CustomWrappers.performActionUntilleleFound(delteBtn, emptySubTotal);
		}

}
