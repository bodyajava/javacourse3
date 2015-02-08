package automation.applogic;

import org.openqa.selenium.By;

public class NavigationHelper extends DriverBasedHelper {
	
	private String baseUrl;
	
	public NavigationHelper (ApplicationManager manager) {
		super(manager.getWebDriver());
		this.baseUrl = manager.getBaseUrl();
	}
	
	public void openMainPage() {
	    driver.get(baseUrl);
	}
	
	public void openRelativeUrl(String url) {
	    driver.get(baseUrl + url);
	}

	public void openMainPageAsLogged() {
		
		// TODO Auto-generated method stub
		
	}

}
