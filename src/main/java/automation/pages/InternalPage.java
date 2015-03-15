package automation.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import automation.model.Movie;

public class InternalPage extends AnyPage {
	
	public InternalPage(PageManager pages) {
		super(pages);
	}
	
	public InternalPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.cssSelector("nav")));
		return this;
	}
	
	public InternalPage ensureResultsFound() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.xpath("//*[contains(@id, 'results')]")));
		return this;
	}
	
	public InternalPage ensureMoviesAppear() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.xpath("//*[contains(@class, 'movie_box')]")));
		return this;
	}
	
	public InternalPage ensureMoviesDissapear() {
		super.ensurePageLoaded();
		wait.until(invisibilityOfElementLocated(By.xpath("//*[contains(@class, 'movie_box')]")));
		return this;
	}
	
	public InternalPage ensureNoResultsTextFound() {
		super.ensurePageLoaded();
		wait.until(visibilityOfElementLocated(By.cssSelector("//*[contains(@class, 'content')]")));
		return this;
	}
	
	@FindBy(css = "nav a[href $= '?go=profile']")
	private WebElement userProfileLink;
	
	@FindBy(css = "nav a[href $= '?go=users']")
	private WebElement userManagementLink;
	
	@FindBy(css = "nav a[onclick $= '?logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath = ".//nav/ul/li[1]/div/div/a/img")
	private WebElement addMovieButton;
	
	@FindBy(xpath = ".//*[@id='q']")
	private WebElement searchField;
	
	@FindBy(xpath = "//*[contains(@id, 'results')]")
	private WebElement results;
	
	@FindBy(xpath = "//*[contains(@class, 'movie_box')]")
	private WebElement movieBox;
	
	@FindBy(xpath = "//*[contains(@class, 'content')]")
	private WebElement noResults;	
	
	public MovieAddNewPage clickAddMovieButton() {
		addMovieButton.click();
		return pages.movieAddNewPage;
	}

	public void openMovie() {
		movieBox.click();
	}

	public InternalPage searchForMovie(Movie movie) {
		searchField.clear();
		searchField.sendKeys(Keys.RETURN);
		wait.until(presenceOfElementLocated(By.xpath("//*[contains(@id, 'results')]")));
		
		searchField.sendKeys(movie.getTitle());
		searchField.sendKeys(Keys.RETURN);
		wait.until(presenceOfElementLocated(By.xpath("//*[contains(@id, 'results')]")));
		
		return this;
	}

	public boolean searchForAbsentMovie(Movie movie) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isMovieAbsent() {
		//System.out.println(driver.findElement(By.xpath("html/body/div[1]/div/div/section/div[3]/div[1]")).getText());
		//return driver.findElement(By.xpath(".//section/div[3]/div[1]")).;
		return true;
	}
	
}