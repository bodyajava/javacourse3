package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class AddMovie extends automation.pages.TestBase {
	private String title;
	private String year;
	private String plot;
	private String producer;
	private String year1;
	private String plot1;
	private String producer1;
	private String site_title;
	private String site_plot;
	private String site_producer;
	
	@Test
	public void addValidMovie() throws Exception{
		title = "Hitch";
		year = "2005";
		plot = "Alex 'Hitch' Hitchens (Will Smith) is a professional 'date doctor' who coaches other men in the art of wooing women, with a focus on long-term relationships. While coaching one of his clients, Albert Brennaman (Kevin James), who is smitten with a client of his investment firm, celebrity Alegra Cole (Amber Valletta).";
		producer = "James Lassiter";
		
		// add new movie
		driver.findElement(By.xpath(".//section/nav/ul/li[1]/div/div/a/img")).click();
		
		// fill out the add movie form
		driver.findElement(By.xpath(".//tr[2]/td[2]/input")).sendKeys(title);
		driver.findElement(By.xpath(".//tr[4]/td[2]/input")).sendKeys(year);
		//setClipboardContents(plot); - не могу использовать эту команду на маке, поэтому пока использую sendKeys
		//driver.findElement(By.xpath(".//tr[17]/td[2]/textarea")).sendKeys(Keys.COMMAND + "v");
		driver.findElement(By.xpath(".//tr[17]/td[2]/textarea")).sendKeys(plot);
		driver.findElement(By.xpath(".//tr[27]/td[2]/textarea")).sendKeys(producer);
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
				
		// verify if information was added
		site_title = driver.findElement(By.xpath(".//div[2]/h2")).getText();
		title = title + " (" + year + ")";
		site_plot = driver.findElement(By.xpath(".//div[2]/div[15]/div")).getText();
		site_producer = driver.findElement(By.xpath(".//div[2]/div[10]")).getText();		
		producer = "Producer: " + producer; 
		assertEquals(site_title, title);
		assertEquals(site_plot, plot);
		assertEquals(site_producer, producer);
		
		driver.findElement(By.xpath(".//header/div/a/h1")).click();
	}
	
	@Test
	public void addInvalidMovie() throws Exception{
		year1 = "2006";
		plot1 = "In Reef City, an underachieving bluestreak cleaner wrasse named Oscar fantasizes about being rich and famous while making his way to work as a tongue scrubber at the local Whale Wash, a job in which he is following in his father's footsteps.";
		producer1 = "Bill Damaschke";
		
		// add new movie
		driver.findElement(By.xpath(".//section/nav/ul/li[1]/div/div/a/img")).click();
		
		// fill out not full movie form
		driver.findElement(By.xpath(".//tr[4]/td[2]/input")).sendKeys(year1);
		driver.findElement(By.xpath(".//tr[17]/td[2]/textarea")).sendKeys(plot1);
		driver.findElement(By.xpath(".//tr[27]/td[2]/textarea")).sendKeys(producer1);
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
				
		isElementPresent(By.xpath(".//tr[2]/td[2]/label"));
		
		driver.findElement(By.xpath(".//header/div/a/h1")).click();		
	}
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	

}
