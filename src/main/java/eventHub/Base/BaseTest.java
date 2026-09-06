package eventHub.Base;



import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import eventHub.Factory.PlayWrightFactory;
import eventHub.Pages.CreateEventPage;
import eventHub.Pages.EventPage;
import eventHub.Pages.HomePage;
import eventHub.Pages.LoginPage;

public class BaseTest {
	PlayWrightFactory pf;
	protected Page page;
	protected Properties prop;
	protected LoginPage loginPage;
	protected HomePage homePage;
	
	
	@BeforeTest
	public void setUp() {
		pf= new PlayWrightFactory();
		prop=pf.init_Properries();
		System.out.println(prop.getProperty("browser"));
		page=pf.initBrowser(prop);
		loginPage=new LoginPage(page);	
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
