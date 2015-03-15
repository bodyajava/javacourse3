package automation;

import static org.junit.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.model.Movie;

public class MovieSearch_Model extends automation.base.TestBaseModel {
	
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			app.getUserHelper().loginAs(ADMIN);
	    }   
	}
	
	@Test
	public void searchPresentMovie() throws Exception {
		Movie movie = new Movie()
			.setTitle("Wild Wild West");
		app.getSearchHelper().searchForMovie(movie);
		assertTrue(app.getSearchHelper().isMovieFound(movie));
	}
	
	@Test
	public void searchAbsentMovie() throws Exception {
		Movie movie = new Movie()
			.setTitle("Costner");
		app.getSearchHelper().searchForMovie(movie);
		assertTrue(app.getSearchHelper().isNoMovieFound());
	}

}
