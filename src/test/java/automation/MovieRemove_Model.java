package automation;

import org.testng.annotations.*;
import static org.junit.Assert.*;
import automation.model.Movie;

public class MovieRemove_Model extends automation.base.TestBaseModel {
	
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			app.getUserHelper().loginAs(ADMIN);
	    }
	    
	}
	
	@Test
	public void testRemoveMovie() throws Exception {
		Movie movie = new Movie().setTitle("Wild Wild West");
		app.getMovieHelper().removeMovie(movie);
		assertTrue(app.getMovieHelper().isMovieRemovedAs(movie));
	}

}
