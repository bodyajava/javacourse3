package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.*;

public class DeleteMovieDescription extends automation.pages.TestBase {
	
	@Test
	public void DeleteDescription() throws Exception{
		
		// open movie
		driver.findElement(By.xpath(".//*[@id='movie_20']/div[2]")).click();
		driver.findElement(By.xpath(".//li[3]/div/div/a/img")).click();
		
		// update movie - delete some description
		driver.findElement(By.xpath(".//tr[17]/td[2]/textarea")).clear();
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
				
		// verify if information was updated
		isElementNotPresent(By.xpath(".//div[15]/h3"));
		isElementNotPresent(By.xpath(".//div[15]/div"));
		
		driver.findElement(By.xpath(".//header/div/a/h1")).click();
	}
	
	private boolean isElementNotPresent(By by) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	    try {
	    	driver.findElement(by);
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	return false;
	    } catch (NoSuchElementException e) {
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	return true;
	    }    
	}
	

}
