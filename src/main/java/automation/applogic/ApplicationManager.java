package automation.applogic;

import org.openqa.selenium.WebDriver;
import automation.applogic.UserHelper;
import automation.applogic.MovieHelper;
import automation.applogic.NavigationHelper;
import automation.util.Browser;
import automation.util.PropertyLoader;
import automation.webdriver.WebDriverFactory;

public class ApplicationManager {
	
	private UserHelper userHelper;
	private MovieHelper movieHelper;
	private NavigationHelper navHelper;
	private SearchHelper searchHelper;
	private MailHelper mailHelper;
	private WebDriver driver;
	private String baseUrl;
	
	public ApplicationManager() {
		baseUrl = PropertyLoader.loadProperty("site.url");
		String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
		
		Browser browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));
		
		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");
		
		driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		userHelper = new UserHelper(this);
		movieHelper = new MovieHelper(this);
		navHelper = new NavigationHelper(this);
		searchHelper = new SearchHelper(this);
		
		getNavigationHelper().openRelativeUrl("php4dvd/");
	}
	
	public UserHelper getUserHelper() {
		return userHelper;
	}
	
	public MovieHelper getMovieHelper() {
		return movieHelper;
	}
	
	public NavigationHelper getNavigationHelper() {
		return navHelper;
	}
	
	public SearchHelper getSearchHelper() {
		return searchHelper;
	}
	
	public MailHelper getMailHelper() {
		return mailHelper;
	}
	
	protected WebDriver getWebDriver() {
		return driver;
	}
	
	protected String getBaseUrl() {
		return baseUrl;
	}
	
	public void stop() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
