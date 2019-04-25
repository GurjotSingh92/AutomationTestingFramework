package amazonAutoTestingWork;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amazonAutoTestingFramework.pageObjects.AddToCartPage;
import amazonAutoTestingFramework.utils.ExtentTestManager;
import amazonAutoTestingFramework.utils.Utilities;

public class AddToCartTest extends BaseTest {
	AddToCartPage addToCart = new AddToCartPage();
	private String itemCodeTD;
	
	@BeforeClass(alwaysRun = true)
	private void setup() {
		itemCodeTD=Utilities.getValue(pageContent, "itemCode");
		
	}
	
	@Test(priority=1,groups = { "addToCart"})
	public void addtheItemTocart() {
		ExtentTestManager.getExtentTest().setDescription("Add the item to cart");
		boolean cartVal=addToCart.addToCart(itemCodeTD);
		if(!cartVal) {
			throw new AssertionError();
		}
	}
	
	@Test(priority=2,dependsOnGroups = { "addToCart" })
	public void changeItemQuanitiy() {
		ExtentTestManager.getExtentTest().setDescription("Uptdate the quantity of an item");
		boolean qty=addToCart.updateItemQuantity();
		if(!qty) {
			throw new AssertionError();
		}
	}
	
	
	
	
	

}
