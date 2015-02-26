package automation.applogic;

public class MailHelper extends DriverBasedHelper {

	public MailHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
	}
	
	public void viewFolders() {
		
	}

	public void openMainpage() {
		pages.mailMainPage.ensurePageLoaded();
		// TODO Auto-generated method stub
		
	}

}
