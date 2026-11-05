package learning_baseclass;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class LeadTest extends BaseClass{
	@Test
	public void createleadsTest() {
		Reporter.log("create leads", true);
		Reporter.log("verify leads", true);
	}
}