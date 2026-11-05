package learning_baseclass;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ContactTest extends PracticeBase {
	@Test
	public void createContactTest() {
		Reporter.log("create contact", true);
		Reporter.log("verify contact", true);
}
}
