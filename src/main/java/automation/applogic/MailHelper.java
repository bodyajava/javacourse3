package automation.applogic;

public class MailHelper extends DriverBasedHelper {

	public MailHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
	}
	
	public void viewFolders() {
		pages.mailPage.ensurePageLoaded();
		pages.mailPage.openAjaxFolder().waitFolderOpened();
		pages.mailPage.openAnnouncementsFolder().waitFolderOpened();
		pages.mailPage.openAccessFolder().waitFolderOpened();
		pages.mailPage.openSilverlightFolder().waitFolderOpened();
		pages.mailPage.openWinFormsFolder().waitFolderOpened();
		pages.mailPage.openWpfFolder().waitFolderOpened();
		
	}

}
