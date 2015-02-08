package automation.applogic;

import org.openqa.selenium.By;

import automation.model.Movie;
import automation.pages.MovieProfilePage;

public class MovieHelper extends DriverBasedHelper {

	public MovieHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
	}

	public void addMovie(Movie movie) {
		pages.internalPage.ensurePageLoaded().clickAddMovieButton();
		pages.movieAddNewPage.ensurePageLoaded()
			.setTitleField(movie.getTitle())
			.setYearField(movie.getYear())
			.setPlotField(movie.getPlot())
			.setProducerField(movie.getProducer())
			.clickSaveMovieButton();
	}
	
	public boolean isMovieAddedAs(Movie movie) {
		return isMovieAdded()
				&& getAddedMovie().getTitle().equals(movie.getTitle() + " (" + movie.getYear() + ")"); 
	}
	
	public void removeMovie(Movie movie) {
		pages.internalPage.ensurePageLoaded().searchForMovie(movie).openMovie();
		pages.movieProfilePage.ensurePageLoaded().clickRemoveMovieButton();		
	}
	
	public boolean isMovieRemovedAs(Movie movie) {
		return pages.internalPage.waitPageLoaded()
				&& pages.internalPage.isMovieAbsent();
	}
		
	public boolean isMovieAdded() {
		return pages.movieProfilePage.waitPageLoaded();
	}

	private Movie getAddedMovie() {
		MovieProfilePage movieProfile = pages.movieProfilePage.ensurePageLoaded();
		return new Movie().setTitle(movieProfile.getMovieTitle());
		
	}
	
	

}
