package automation;

import org.testng.annotations.*;
import static org.junit.Assert.*;
import automation.model.Movie;

public class MovieAddNew_Model extends automation.base.TestBaseModel {
	
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			app.getUserHelper().loginAs(ADMIN);
	    }
	    
	}
	
	@Test
	public void testAddMovie() throws Exception {
		Movie movie = new Movie()
			.setTitle("Wild Wild West")
		  	.setYear("1999")
		  	.setPlot("Starting in a small section of the near South, both Captain James West and Marshall Artemus Gordon hunt for General 'Bloodbath' McGrath, who is wanted for mass murder. It points back to when McGrath ordered a massacre in a settlement called New Liberty, where many of the freed slaves were murdered, including West's biological parents. The search leads to a brothel where the two try (unsuccessfully) to arrest him. It leads to a huge brawl and a cart of nytroglycerin crashing into the building that starts a fire.")
		  	.setProducer("Barry Sonnenfeld");
		app.getMovieHelper().addMovie(movie);
		assertTrue(app.getMovieHelper().isMovieAddedAs(movie));
	}

}