package eventHubTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import eventHub.Base.BaseTest;
import eventHub.Pages.CreateEventPage;
import eventHub.Pages.EventPage;
import eventHub.Pages.HomePage;

public class CreateEventPageTest extends BaseTest {
	
	HomePage homePage;
	CreateEventPage createEventPage;
	EventPage eventPage;
	

	@Test(groups = "regression",priority = 1)
	public void MoveToEventPageTest() {
		homePage=loginPage.LoginToApplication(prop.getProperty("username"), prop.getProperty("password"));
		createEventPage=homePage.getMoveToEventsClick(); 
		Assert.assertTrue(createEventPage.getNewEventDisplay());
	}
	@Test(groups = "regression",priority = 2)
	public void EventPageTitleTest() {
		String title=createEventPage.getEventPageTitle();
		//System.out.println(title);
		Assert.assertEquals(title, "EventHub — Discover & Book Events");
	}
	@Test(groups = "regression",priority = 3)
	public void EventPageUrlTest() {
		String url= createEventPage.getEventPageUrl();
		//System.out.println(url);
		Assert.assertEquals(url, "https://eventhub.rahulshettyacademy.com/admin/events");
	}
	@Test(groups = "regression",priority = 4)
	public void CreateNewEventTest() {
		createEventPage.getCreateNewEvent();
		Assert.assertTrue(page.getByText("Event created!").isVisible());
		
	}
	@Test(groups = "regression",priority = 5)
	public void ToCheckEventIsAdded() {
		eventPage= createEventPage.getClickOnEventLink();
		Assert.assertTrue(eventPage.getIsEventCardAdded());
	}

}
