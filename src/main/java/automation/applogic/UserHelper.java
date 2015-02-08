package automation.applogic;

import automation.model.User;

public class UserHelper extends DriverBasedHelper {
	
	public UserHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
	}
	
	public void loginAs(User user) {
		pages.loginPage.ensurePageLoaded()
			.setUsernameField(user.getLogin())
			.setPasswordField(user.getPassword())
			.clickSubmitButton();
	}
		
	public boolean isLoggedIn() {
		return pages.internalPage.waitPageLoaded();
	}

	public boolean isNotLoggedIn() {
		return pages.loginPage.waitPageLoaded();
	}


}
