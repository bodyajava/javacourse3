package automation.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieProfilePage extends InternalPage {

	public MovieProfilePage(PageManager pages) {
		super(pages);
	}
	
	public MovieProfilePage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("movie")));
		return this;
	}
	
	@FindBy(xpath = ".//div[1]/div[2]/h2")
	private WebElement titleAndYearText;
	
	@FindBy(xpath = ".//div[2]/div[10]")
	private WebElement producerText;

	@FindBy(xpath = ".//div[2]/div[15]")
	private WebElement plotText;
	
	@FindBy(xpath = ".//li[4]/div/div/a/img")
	private WebElement removeButton;
		
	public String getMovieTitle() {
		return titleAndYearText.getText();
	}

	public void clickRemoveMovieButton() {
		removeButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();		
	}

}
