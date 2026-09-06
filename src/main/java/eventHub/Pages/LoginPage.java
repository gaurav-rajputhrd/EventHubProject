package eventHub.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
	
	private Locator email;
	private Locator password;
	private Locator signInBtn;
	private Page page;
	
	public LoginPage(Page page) {
		this.page=page;
		
		this.email= page.getByPlaceholder("you@email.com");
		this.password= page.getByLabel("Password");
		this.signInBtn= page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In"));
	}
	public String LoginPageTitle() {
		return page.title();
	}
	public String LoginPageURL() {
		 return page.url();
	}
	public HomePage LoginToApplication(String Uemail,String pass) {
		email.fill(Uemail);
		password.fill(pass);
		signInBtn.click();
		return new HomePage(page);
	}

}
