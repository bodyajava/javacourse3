package automation;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MovieSearch extends automation.pages.TestBase {
	private String movie;
	private String movie1;
	private String site_movie;
	private String site_movie1;	
	private String nomovie;
	private String site_nomovie;
	
	@Test
	public void SearchValidMovie() throws Exception{
		
		//movie #1
		driver.findElement(By.xpath(".//*[@id='q']")).clear();
		driver.findElement(By.xpath(".//*[@id='q']")).sendKeys(Keys.RETURN);
		movie = "Men in Black 3";
		driver.findElement(By.xpath(".//*[@id='q']")).sendKeys("black" + Keys.RETURN);
		site_movie = driver.findElement(By.xpath(".//*[@id='movie_25']/div[2]")).getText();
		assertEquals(site_movie, movie);
		
		//movie #2
		driver.findElement(By.xpath(".//*[@id='q']")).clear();
		driver.findElement(By.xpath(".//*[@id='q']")).sendKeys(Keys.RETURN);
		movie1 = "The Pursuit of Happyness";
		driver.findElement(By.xpath(".//*[@id='q']")).sendKeys("pursuit" + Keys.RETURN);
		site_movie1 = driver.findElement(By.xpath(".//*[@id='movie_21']/div[2]")).getText();
		assertEquals(site_movie1, movie1);
	}
	
	@Test
	public void SearchInvalidMovie() throws Exception{
		
		driver.findElement(By.xpath(".//*[@id='q']")).clear();
		driver.findElement(By.xpath(".//*[@id='q']")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath(".//*[@id='q']")).sendKeys("abrakadabra" + Keys.RETURN);
		
		nomovie = "No movies where found.";
		site_nomovie = driver.findElement(By.xpath(".//div[3]/div[1]")).getText();
		System.out.println(site_nomovie);
		System.out.println(nomovie);
		assertEquals(site_nomovie, nomovie);
	}	
	
}
