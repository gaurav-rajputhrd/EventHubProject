package eventHub.Pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class EventPage {
	
	private Locator eventsCards;
	Page page;
	
	public EventPage(Page page) {
		this.page=page;
		this.eventsCards= page.getByTestId("event-card");
	}
	
	public boolean getIsEventCardAdded() {
		System.out.println(eventsCards.count());
		Locator targetCard= eventsCards.filter(new Locator.FilterOptions().setHasText("Chess Game"));
		 assertThat(targetCard).isVisible();
		return true;
	}
	
	public String getEventPageTitle() {
		return page.title();
	}
	public String getEventPageUrl() {
		return page.url();
	}
	
	

}
