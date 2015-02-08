package automation.base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterSuite;

import automation.applogic.ApplicationManager; 
import automation.model.User;

public class TestBaseModel {
	
	public static User ADMIN = new User().setLogin("admin").setPassword("admin");
	protected ApplicationManager app;
	
	@BeforeClass
	public void init() {
		app = new ApplicationManager();
	}
	
	@AfterSuite
	public void stop() {
		app.stop();
	}

}
