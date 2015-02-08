package automation.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieAddNewPage extends InternalPage {
	
	public MovieAddNewPage(PageManager pages) {
		super(pages);
	}
	
	public MovieAddNewPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("imdbsearch")));
		return this;
	}
	
	@FindBy(xpath = ".//tr[2]/td[2]/input")
	private WebElement titleField;
	
	@FindBy(xpath = ".//tr[4]/td[2]/input")
	private WebElement yearField;
	
	@FindBy(xpath = ".//tr[17]/td[2]/textarea")
	private WebElement plotField;
	
	@FindBy(xpath = ".//tr[27]/td[2]/textarea")
	private WebElement producerField;
	
	@FindBy(xpath = ".//tr[30]/td[2]/input")
	private WebElement saveButton;
	
	public MovieAddNewPage setTitleField(String text) {
		titleField.sendKeys(text);
	    return this;
	}
	
	public MovieAddNewPage setYearField(String text) {
		yearField.sendKeys(text);
	    return this;
	}
	
	public MovieAddNewPage setPlotField(String text) {
		plotField.sendKeys(text);
	    return this;
	}
	
	public MovieAddNewPage setProducerField(String text) {
		producerField.sendKeys(text);
	    return this;
	}
	
	public MovieAddNewPage clickSaveMovieButton() {
		saveButton.click();
	    return this;
	}

}
