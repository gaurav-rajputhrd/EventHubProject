package eventHubTests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowConceptTest {
	
	@Test(groups = "smoke")
	public void getMethod()
	{
		Playwright playwright= Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
		BrowserContext context= browser.newContext();
		Page page= context.newPage();
		page.navigate("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(page.url());
		
		Page newpage= context.waitForPage(()->page.locator(".blinkingText").first().click());
		System.out.println(newpage.url());
		
		String text= newpage.locator(".red").innerText();
		System.out.println(text);
		String emailId= text.split("at ")[1].split(" ")[0];
		System.out.println(emailId);
		page.getByLabel("Username:").fill(emailId);
		page.waitForTimeout(4000);
	}
}
