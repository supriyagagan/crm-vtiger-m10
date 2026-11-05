package learning_baseclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PracticeBase {
	@BeforeClass
	public void setUp() {
		System.out.println("open browser");
	}

	@BeforeClass
	public void login() {
		System.out.println("login");
	}

	@AfterClass
	public void logout() {
		System.out.println("logout");
	}

	@AfterClass
	public void tearDown() {
	
	System.out.println("tearDown");
}
}
