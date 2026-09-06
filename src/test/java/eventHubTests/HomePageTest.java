package eventHubTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import eventHub.Base.BaseTest;
import eventHub.Pages.HomePage;

public class HomePageTest extends BaseTest {
	HomePage homePage;
	
	@Test(groups = "regression", priority = 1)
	public void LoginSuccessFullToHomePageTest() {
		homePage=loginPage.LoginToApplication(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(homePage.getCheckEmailIdInHomePage());
	}
	@Test(groups = "regression", priority = 2)
	public void HomepageTitleTest() {
		String title= homePage.getHomePageTitle();
		System.out.println("HomePage Title "+title);
		Assert.assertEquals(title, "EventHub — Discover & Book Events");
	}
	@Test(groups = "regression", priority = 3)
	public void HomePageUrlTest() {
		String url= homePage.getHomePageUrl();
		System.out.println("Home Page URL :"+url);
		Assert.assertEquals(url, "https://eventhub.rahulshettyacademy.com/");
	}

}
