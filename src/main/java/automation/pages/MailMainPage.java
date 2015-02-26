package automation.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.By;

public class MailMainPage extends AnyPage {

	public MailMainPage(PageManager pages) {
		super(pages);
	}
	
	public MailMainPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("logo")));
		return this;
	}

}
