package beam_Amazon_Auto.pageObjects;

import org.openqa.selenium.By;

import beam_Amazon_Auto.utils.helpers.CustomWrappers;


public class LoginPage extends BasePage{
	
	private By signIn = utility.getLocator("signIn");
	private By emailId=utility.getLocator("emailId");
	private By continueBtn=utility.getLocator("continueBtn");
	private By password=utility.getLocator("password");
	private By submitBtn=utility.getLocator("submitBtnLogin");
	
	public void loginInTheWebsite(String phoneNumber,String password) {
		//CustomWrappers.customClick(signIn, 10);
		enterLoginDetails(phoneNumber,password);
	}
	
	public void enterLoginDetails(String phoneNumber,String passwordText) {
			CustomWrappers.waitAndEnterText(emailId, phoneNumber, 10);
			CustomWrappers.customClick(continueBtn, 10);
			CustomWrappers.waitAndEnterText(password, passwordText, 10);
			CustomWrappers.customClick(submitBtn, 20);
			CustomWrappers.isElementDisplayed(signIn, 10);
	}

}
