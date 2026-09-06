package eventHub.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CreateEventPage{
	private Locator newEventDisplay;
	private Locator enterTitle;
	private Locator enterDescription;
	private Locator selectcategory;
	private Locator enterCity;
	private Locator enterVenue;
	private Locator enterEventDateAndTime;
	private Locator enterPrice;
	private Locator enterTotalSeats;
	private Locator clickAddEventButton;
	private Locator eventLinkClick;
	
	private Page page;
	public CreateEventPage(Page page) {
		this.page=page;
		this.newEventDisplay=page.locator(".text-lg.font-bold.text-gray-900.mb-2");
		this.enterTitle=page.getByLabel("Title");
		this.enterDescription= page.getByPlaceholder("Describe the event…");
		this.selectcategory= page.getByLabel("Category");
		this.enterCity=page.getByLabel("city");
		this.enterVenue=page.getByLabel("Venue");
		this.enterEventDateAndTime= page.getByLabel("Event Date & Time");
		this.enterPrice= page.getByLabel("Price ($)");
		this.enterTotalSeats= page.getByLabel("Total Seats");
		this.clickAddEventButton= page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("+ Add Event"));
		this.eventLinkClick= page.locator("#nav-events");
		
	}
	
	public boolean getNewEventDisplay() {
		page.waitForTimeout(2000);
		return newEventDisplay.isVisible();
	}
	
	public String getEventPageTitle() {
		return page.title();
	}
	public String getEventPageUrl() {
		return page.url();
	}
	public void getCreateNewEvent() {
		enterTitle.fill("Chess Game");
		enterDescription.fill("National Chess Series");
		selectcategory.selectOption("Sports");
		enterCity.fill("Ghaziabad");
		enterVenue.fill("Natioal Club Uttara Pradesh");
		enterEventDateAndTime.fill("2026-09-30T16:09");
		enterPrice.fill("100");
		enterTotalSeats.fill("10");
		clickAddEventButton.click();
		page.waitForTimeout(2000);
	}
	public EventPage getClickOnEventLink() {
	 	eventLinkClick.click();
	 	return new EventPage(page);
	}
	
}
