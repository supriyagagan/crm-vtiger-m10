package learning_baseclass;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class OppTest extends PracticeBase{
	@Test
	public void createleadsTest() {
		Reporter.log("create leads", true);
		Reporter.log("verify leads", true);
	}
}