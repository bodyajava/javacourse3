package automation.applogic;

import org.openqa.selenium.By;
import automation.model.Movie;

public class SearchHelper extends DriverBasedHelper {
	
	private String baseUrl;
	
	public SearchHelper (ApplicationManager manager) {
		super(manager.getWebDriver());
		this.baseUrl = manager.getBaseUrl();
	}

	public void searchForMovie(Movie movie) {
		pages.internalPage.ensurePageLoaded();
		pages.internalPage.searchForMovie(movie);		
	}

	public boolean isMovieFound(Movie movie) {
		pages.internalPage.ensureResultsFound();
		pages.internalPage.ensureMoviesAppear();
		return driver.findElement(By.xpath("//*[contains(@title, '"+ movie.getTitle() + "')]")).isDisplayed()
				&& ! driver.findElement(By.xpath("//*[contains(@class, 'content')]")).isDisplayed();
	}

	public boolean isNoMovieFound() {
		pages.internalPage.ensureResultsFound();
		pages.internalPage.ensureMoviesDissapear();
		//System.out.println(driver.findElement(By.xpath("//*[contains(@class, 'content')]")).getText());
		return driver.findElement(By.xpath("//*[contains(@class, 'content')]")).getText().equals("No movies where found.");
	}

}
