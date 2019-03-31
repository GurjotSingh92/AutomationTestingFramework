package beam_Amazon_Auto.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import beam_Amazon_Auto.pageObjects.AddToCartPage;
import beam_Amazon_Auto.utils.ExtentTestManager;
import beam_Amazon_Auto.utils.Utilities;

public class AddToCartTest extends BaseTest {
	AddToCartPage addToCart = new AddToCartPage();
	private String itemCodeTD;
	
	@BeforeClass(alwaysRun = true)
	private void setup() {
		System.out.println("this is before class in Add to cart test");
		itemCodeTD=Utilities.getValue(pageContent, "itemCode");
		
	}
	
	@Test(priority=1,groups = { "addToCart"})
	public void addtheItemTocart() {
		ExtentTestManager.getTest().setDescription("Add the item to cart");
		boolean cartVal=addToCart.addToCart(itemCodeTD);
		if(!cartVal) {
			throw new AssertionError();
		}
	}
	
	@Test(priority=2,dependsOnGroups = { "addToCart" })
	public void changeItemQuanitiy() {
		ExtentTestManager.getTest().setDescription("Uptdate the quantity of an item");
		boolean qty=addToCart.updateItemQuantity();
		if(!qty) {
			throw new AssertionError();
		}
	}
	
	
	
	
	

}
