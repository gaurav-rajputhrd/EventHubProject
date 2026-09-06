package eventHubTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import eventHub.Base.BaseTest;
import eventHub.Constants.AppConstants;


public class LoginPageTest extends BaseTest {
	

	
	
	@Test(groups = "regression",priority = 1)
	public void LoginTitlePageTest() {
		String title =loginPage.LoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title,AppConstants.LOGIN_PAGE_TITLE);
	}
	@Test(groups = "regression",priority = 2)
	public void LoginPageURLTest() {
		String actualUrl= loginPage.LoginPageURL();
		System.out.println(actualUrl);
		Assert.assertEquals(actualUrl,prop.getProperty("url"));
	}
	@Test(priority = 3,groups = "regression")
	public void LoginToLoginPageTest() {
		
		homePage=loginPage.LoginToApplication("gaurav.rajput04@gmail.com", "Sahaj@224565");
	
	}
	

}
