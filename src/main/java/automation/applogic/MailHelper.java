package automation.applogic;

public class MailHelper extends DriverBasedHelper {

	public MailHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
	}
	
	public void viewFolders() {
		pages.mailPage.ensurePageLoaded();
		pages.mailPage.openAjaxFolder().waitAjaxFolderOpened();
		pages.mailPage.openAnnouncementsFolder().waitAnnouncementsFolderOpened();
		pages.mailPage.openAccessFolder().waitAccessFolderOpened();
		pages.mailPage.openSilverlightFolder().waitSilverlightFolderOpened();
		pages.mailPage.openWinFormsFolder().waitWinFormsFolderOpened();
		pages.mailPage.openWpfFolder().waitWpfFolderOpened();
		
	}

}
