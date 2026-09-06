package eventHub.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext= new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage= new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright= new ThreadLocal<>();
	
	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}
	public static Page getPage() {
		return tlPage.get();
	}
	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}
	public static Browser getBrowser() {
		return tlBrowser.get();
	}
	
	
	public Page initBrowser(Properties prop) {
		String browsername= System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		String envName= System.getProperty("env")!=null?System.getProperty("env"):prop.getProperty("env");
		//String browsername=prop.getProperty("browser").trim();
		System.out.println("Browser name is :"+browsername);
		
		//playwright=Playwright.create();
		tlPlaywright.set(Playwright.create());
		switch (browsername.toLowerCase()) {
		case "chromium":
			//browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "safari":
			//browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "chrome":
			//browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser "+browsername);
		}
		tlBrowserContext.set(getBrowser().newContext());
		//browserContext= browser.newContext();
		tlPage.set(getBrowserContext().newPage());
		//page= browserContext.newPage();
		getPage().navigate(prop.getProperty(envName+".base_url"));
		//page.navigate(prop.getProperty("url"));
	
		return getPage();
		
	}
	public Properties init_Properries() {
		
		try {
			
			FileInputStream file= new FileInputStream("D:\\eclipse-workspace\\EventHubByNaveen\\src\\test\\resources\\config\\config.properties");
			prop=new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String takeScreenshot() {
		String path=System.getProperty("user.dir")+"/screenshot/" +System.currentTimeMillis()+".png";
		getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		return path;
		
		
	}
}
