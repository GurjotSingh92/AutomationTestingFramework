package beam_Amazon_Auto.pageObjects;

import org.openqa.selenium.By;

import beam_Amazon_Auto.utils.helpers.CustomWrappers;
import beam_Amazon_Auto.utils.helpers.WebDriverManager;


public class AddToCartPage extends BasePage {

	private By itemClass = utility.getLocator("itemClass");
	private By proceedToCheckOut = utility.getLocator("proceedToCheckOut");
	private By updatedQty=utility.getLocator("updatedQtnty");

	//add the item to cart
	public boolean addToCart(String item) {
		try {
			WebDriverManager.getURL("chrome", url);
			CustomWrappers.waitAndEnterText(searchBar, item, 10);
			CustomWrappers.customClick(submitBtn, 20);
			CustomWrappers.customClick(itemClass, 20);
	        Thread.sleep(5000);
	        CustomWrappers.sikuli_init_2("addToCart.png");
	        CustomWrappers.sikuli_init("cartBtn.png");
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//update the quantity of item
	public boolean updateItemQuantity() {
		try {
			CustomWrappers.sikuli_init("dropdown.png");
			CustomWrappers.sikuli_init("four.png");
			CustomWrappers.sikuli_init("Subtotal.png","Off");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//proceed to checkout
	public void proceedToCheckOut() {
		try {
			WebDriverManager.getURL("chrome", url);
			CustomWrappers.customClick(proceedToCheckOut, 20);
			CustomWrappers.scrollInPage("up");

		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	

}
