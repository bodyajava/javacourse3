package automation;

import org.testng.annotations.*;
import static org.junit.Assert.*;

public class MailFoldersView extends automation.base.TestBaseModel {
	
	@Test
	public void viewFolders() {
		app.getMailHelper().viewFolders();
	}

}
