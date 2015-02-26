package automation.applogic;

import automation.model.Movie;

public class SearchHelper extends DriverBasedHelper {
	
	private String baseUrl;
	
	public SearchHelper (ApplicationManager manager) {
		super(manager.getWebDriver());
		this.baseUrl = manager.getBaseUrl();
	}

	public void searchForMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}

	public boolean isMovieFound(Movie movie) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isMovieNotFound(Movie movie) {
		// TODO Auto-generated method stub
		return false;
	}

}
