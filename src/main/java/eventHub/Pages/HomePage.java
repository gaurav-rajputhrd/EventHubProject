package eventHub.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
	
	private Locator emailDisplay;
	private Locator adminBtn;
	private Locator manageEventLink;
	private Page page;
	public HomePage(Page page) {
		this.page=page;
		this.emailDisplay= page.locator("#user-email-display");
		this.adminBtn= page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Admin"));
		this.manageEventLink= page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Manage Events"));
	}
	
	public boolean HomePageEmailDisplay() {
		return emailDisplay.isVisible();
	}
	
	public String getHomePageTitle() {
		String title=page.title();
		return title;
	}
	public String getHomePageUrl()
	{
		String url =page.url();
		return url;
	}
	public boolean getCheckEmailIdInHomePage() {
		page.waitForTimeout(4000);
		return emailDisplay.isVisible();
	}
	public CreateEventPage getMoveToEventsClick() {
		adminBtn.click();
		page.waitForTimeout(3000);
		manageEventLink.first().click();
		return new CreateEventPage(page);
		
	}
}
