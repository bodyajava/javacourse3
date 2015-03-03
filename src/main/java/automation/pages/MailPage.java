package automation.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends AnyPage {

	public MailPage(PageManager pages) {
		super(pages);
	}
	
	public MailPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("logo")));
		return this;
	}
	
	public MailPage waitFolderOpened() {
		//wait.until(invisibilityOfElementLocated(By.xpath("//table/thead/tr/th[3]/a")));
		wait.until(presenceOfElementLocated(By.xpath("//table/thead/tr/th[3]/a")));
		wait.until(visibilityOfElementLocated(By.xpath("//table/thead/tr/th[3]/a")));
		return this;
	}
	
	@FindBy(xpath = "//li[3]/ul/li[1]/div/span[2]")
	private WebElement AjaxFolder;
	
	@FindBy(xpath = "//li[3]/ul/li[2]/div/span[2]")
	private WebElement AnnouncementsFolder;
	
	@FindBy(xpath = "//li[3]/ul/li[3]/div/span[2]")
	private WebElement AccessFolder;
	
	@FindBy(xpath = "//li[3]/ul/li[4]/div/span[2]")
	private WebElement SilverlightFolder;
	
	@FindBy(xpath = "//li[3]/ul/li[5]/div/span[2]")
	private WebElement WinFormsFolder;
	
	@FindBy(xpath = "//li[3]/ul/li[6]/div/span[2]")
	private WebElement WpfFolder;
	
	@FindBy(xpath = "//table/thead/tr/th[3]/a")
	private WebElement SubjectPanel;
	
	public MailPage openAjaxFolder() 			{AjaxFolder.click(); return this;}
	public MailPage openAnnouncementsFolder()	{AnnouncementsFolder.click(); return this;}
	public MailPage openAccessFolder()			{AccessFolder.click(); return this;}
	public MailPage openSilverlightFolder()		{SilverlightFolder.click(); return this;}
	public MailPage openWinFormsFolder()		{WinFormsFolder.click(); return this;}
	public MailPage openWpfFolder()				{WpfFolder.click(); return this;}

	

}
