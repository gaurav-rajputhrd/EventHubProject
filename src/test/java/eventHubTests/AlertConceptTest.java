package eventHubTests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class AlertConceptTest {
	
	@Test(groups = "smoke")
	public void getMethod() {
		
		Playwright playwright= Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context= browser.newContext();
		Page page= context.newPage();
		page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
		page.onDialog(dialog->{
			String msg =dialog.message();
			System.out.println(msg);
			dialog.accept();
			
		});
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Alert")).click();
		
		
		
		page.waitForTimeout(4000);
	}

}
