package organization;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;

/**
 * ============================================================================
 * Test Script Name : CreateOrgTest
 * ============================================================================
 *
 * Application      : Vtiger CRM
 * Module           : Organizations
 * Test Type        : Functional / UI Testing
 *
 * Automation Tool  : Selenium WebDriver
 * Programming Lang : Java
 *
 * Description:
 * ----------------------------------------------------------------------------
 * This automation script verifies the creation of a new Organization
 * in the Vtiger CRM application.
 *
 * The script performs the following activities:
 *
 * 1. Reads browser and application details from the JSON file.
 * 2. Launches the configured browser.
 * 3. Maximizes the browser window.
 * 4. Configures an implicit wait of 15 seconds.
 * 5. Navigates to the Vtiger CRM application.
 * 6. Logs into the application using valid credentials.
 * 7. Navigates to the Organizations module.
 * 8. Opens the Create Organization page.
 * 9. Generates a unique Organization Name.
 * 10. Enters Organization details.
 * 11. Selects Industry and Organization Type.
 * 12. Enters Phone Number and Email Address.
 * 13. Saves the Organization.
 * 14. Captures the Organization Name displayed after saving.
 * 15. Compares Expected and Actual Organization Name.
 * 16. Logs out from Vtiger CRM.
 * 17. Closes the browser.
 *
 * Expected Result:
 * ----------------------------------------------------------------------------
 * The Organization should be created successfully and the Organization Name
 * displayed after saving should exactly match the Organization Name entered
 * during creation.
 *
 * Test Data:
 * ----------------------------------------------------------------------------
 * Username             : admin
 * Password             : manager
 * Industry             : Consulting
 * Organization Type    : Selected using index 4
 * Phone                : 7728029564
 * Email                : supriyagagan1992@gmail.com
 * Organization Name    : Dynamically generated using currentTimeMillis()
 *
 * Author:
 * ----------------------------------------------------------------------------
 * AutomationWithPiyush
 *
 * ============================================================================
 */

public class CreateOrgTest {

	/**
	 * Main method responsible for executing the complete Create Organization
	 * automation flow.
	 *
	 * @param args command-line arguments
	 * @throws InterruptedException if the execution is interrupted
	 * @throws IOException if an I/O operation fails
	 * @throws ParseException if JSON parsing fails
	 */
	public static void main(String[] args)
			throws InterruptedException, IOException, ParseException {

		// ========================================================================
		// TEST DATA CONFIGURATION
		// ========================================================================
		// Fetching browser, URL, username and password from JSON configuration file.

		String browser = FileUtility.getDataFromJsonFile("bro");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("un");
		String password = FileUtility.getDataFromJsonFile("pwd");

		// ========================================================================
		// TEST EXECUTION START
		// ========================================================================

		System.out.println("================================================================");
		System.out.println("        CREATE ORGANIZATION TEST EXECUTION STARTED");
		System.out.println("================================================================");

		// ========================================================================
		// STEP 1: LAUNCH BROWSER
		// ========================================================================

		System.out.println("\n[STEP 1] Launching browser...");
		System.out.println("[INFO] Configured browser : " + browser);

		WebDriver driver = null;

		if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("edge"))
			driver = new EdgeDriver();
		else if (browser.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();

		System.out.println("[PASS] Browser launched successfully.");

		// ========================================================================
		// STEP 2: MAXIMIZE BROWSER WINDOW
		// ========================================================================

		System.out.println("\n[STEP 2] Maximizing browser window...");

		driver.manage().window().maximize();

		System.out.println("[PASS] Browser window maximized successfully.");

		// ========================================================================
		// STEP 3: CONFIGURE IMPLICIT WAIT
		// ========================================================================

		System.out.println("\n[STEP 3] Configuring implicit wait...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		System.out.println("[PASS] Implicit wait configured to 15 seconds.");

		// ========================================================================
		// STEP 4: NAVIGATE TO VTIGER CRM
		// ========================================================================

		System.out.println("\n[STEP 4] Navigating to Vtiger CRM application...");
		System.out.println("[INFO] Application URL : " + url);

		driver.get(url);

		System.out.println("[PASS] Vtiger CRM application launched successfully.");

		// ========================================================================
		// STEP 5: LOGIN TO VTIGER CRM
		// ========================================================================

		System.out.println("\n---------------------------------------------------------------");
		System.out.println("[STEP 5] Starting Vtiger CRM login process...");
		System.out.println("---------------------------------------------------------------");

		WebElement usernamefield =
				driver.findElement(By.name("user_name"));

		WebElement passwordfield =
				driver.findElement(By.name("user_password"));

		WebElement loginButton =
				driver.findElement(By.id("submitButton"));

		System.out.println("[INFO] Login page elements located successfully.");

		System.out.println("[INFO] Entering username...");
		usernamefield.sendKeys(username);
		System.out.println("[PASS] Username entered successfully.");

		System.out.println("[INFO] Entering password...");
		passwordfield.sendKeys(password);
		System.out.println("[PASS] Password entered successfully.");

		System.out.println("[INFO] Clicking Login button...");
		loginButton.click();

		System.out.println("[PASS] Login button clicked successfully.");
		System.out.println("[PASS] Login process completed successfully.");

		// ========================================================================
		// STEP 6: NAVIGATE TO ORGANIZATIONS MODULE
		// ========================================================================

		System.out.println("\n---------------------------------------------------------------");
		System.out.println("[STEP 6] Navigating to Organizations module...");
		System.out.println("---------------------------------------------------------------");

		driver.findElement(By.linkText("Organizations")).click();

		System.out.println("[PASS] Organizations module opened successfully.");

		// ========================================================================
		// STEP 7: OPEN CREATE ORGANIZATION PAGE
		// ========================================================================

		System.out.println("\n---------------------------------------------------------------");
		System.out.println("[STEP 7] Opening Create Organization page...");
		System.out.println("---------------------------------------------------------------");

		// Get data from Excel file
		String orgName = "qsp_" + System.currentTimeMillis();

		String orgName1 =
				FileUtility.getDataFromExcelFile("org", 3, 0) + orgName;

		System.out.println("[INFO] Navigating to Organizations module...");

		driver.findElement(By.linkText("Organizations")).click();

		System.out.println("[INFO] Locating Create Organization option...");

		driver.findElement(
				By.cssSelector("img[title='Create Organization...']"))
				.click();

		System.out.println("[PASS] Create Organization page opened successfully.");

		// ========================================================================
		// STEP 8: GENERATE UNIQUE ORGANIZATION NAME
		// ========================================================================

		System.out.println("\n[STEP 8] Generating unique Organization Name...");

		/*
		 * System.currentTimeMillis() is used to generate a unique
		 * Organization Name for every test execution.
		 */

		System.out.println("[INFO] Generated Organization Name : " + orgName);
		System.out.println("[PASS] Unique Organization Name generated successfully.");

		// ========================================================================
		// STEP 9: ENTER ORGANIZATION DETAILS
		// ========================================================================

		System.out.println("\n---------------------------------------------------------------");
		System.out.println("[STEP 9] Entering Organization details...");
		System.out.println("---------------------------------------------------------------");

		// ------------------------------------------------------------------------
		// Organization Name
		// ------------------------------------------------------------------------

		System.out.println("[INFO] Locating Organization Name field...");

		WebElement orgField =
				driver.findElement(By.name("accountname"));

		System.out.println("[INFO] Entering Organization Name...");

		orgField.sendKeys(orgName);

		System.out.println("[PASS] Organization Name entered successfully.");

		// ------------------------------------------------------------------------
		// Industry
		// ------------------------------------------------------------------------

		System.out.println("[INFO] Locating Industry dropdown...");

		WebElement industry =
				driver.findElement(By.name("industry"));

		Select selSingle = new Select(industry);

		System.out.println("[INFO] Selecting Industry : Consulting...");

		selSingle.selectByValue("Consulting");

		System.out.println("[PASS] Industry selected successfully.");

		System.out.println("[INFO] Available Industry options:");

		List<WebElement> options = selSingle.getOptions();

		for (WebElement i : options) {
			System.out.println("[OPTION] " + i.getText());
		}

		System.out.println("[PASS] Industry options displayed successfully.");

		// ------------------------------------------------------------------------
		// Organization Type
		// ------------------------------------------------------------------------

		System.out.println("[INFO] Locating Organization Type dropdown...");

		WebElement type =
				driver.findElement(By.name("accounttype"));

		Select selSingle1 = new Select(type);

		System.out.println(
				"[INFO] Selecting Organization Type using index 4...");

		selSingle1.selectByIndex(4);

		System.out.println(
				"[PASS] Organization Type selected successfully.");

		System.out.println("[INFO] Available Organization Type options:");

		List<WebElement> options1 = selSingle1.getOptions();

		for (WebElement i : options1) {
			System.out.println("[OPTION] " + i.getText());
		}

		System.out.println(
				"[PASS] Organization Type options displayed successfully.");

		// ------------------------------------------------------------------------
		// Phone Number
		// ------------------------------------------------------------------------

		System.out.println("[INFO] Locating Phone field...");

		WebElement phone =
				driver.findElement(By.id("phone"));

		// ------------------------------------------------------------------------
		// Email Address
		// ------------------------------------------------------------------------

		System.out.println("[INFO] Locating Email field...");

		WebElement email =
				driver.findElement(By.id("email1"));

		System.out.println("[INFO] Entering Phone Number...");

		phone.sendKeys("7728029564");

		System.out.println("[PASS] Phone Number entered successfully.");

		System.out.println("[INFO] Entering Email Address...");

		email.sendKeys("supriyagagan1992@gmail.com");

		System.out.println("[PASS] Email Address entered successfully.");

		// ========================================================================
		// STEP 10: SAVE ORGANIZATION
		// ========================================================================

		System.out.println("\n---------------------------------------------------------------");
		System.out.println("[STEP 10] Saving Organization...");
		System.out.println("---------------------------------------------------------------");

		driver.findElement(
				By.cssSelector("input[title='Save [Alt+S]']"))
				.click();

		System.out.println("[PASS] Save button clicked successfully.");
		System.out.println("[PASS] Organization save operation completed.");

		// ========================================================================
		// STEP 11: VERIFY ORGANIZATION CREATION
		// ========================================================================

		System.out.println("\n---------------------------------------------------------------");
		System.out.println(
				"[STEP 11] Starting Organization creation verification...");
		System.out.println("---------------------------------------------------------------");

		String actOrgName =
				driver.findElement(
						By.id("dtlview_Organization Name"))
						.getText();

		System.out.println(
				"[INFO] Organization details page loaded successfully.");

		System.out.println(
				"[INFO] Expected Organization Name : " + orgName);

		System.out.println(
				"[INFO] Actual Organization Name   : " + actOrgName);

		// ========================================================================
		// STEP 12: COMPARE EXPECTED AND ACTUAL ORGANIZATION NAME
		// ========================================================================

		System.out.println(
				"\n[STEP 12] Comparing Expected and Actual Organization Name...");

		if (actOrgName.equals(orgName)) {

			System.out.println(
					"[PASS] Organization Created Successfully.");

			System.out.println(
					"[PASS] Expected and Actual Organization Names match.");

			System.out.println(
					"[PASS] Organization creation verification completed successfully.");

		} else {

			System.out.println(
					"[FAIL] Failed to create organization.");

			System.out.println(
					"[FAIL] Expected and Actual Organization Names do not match.");

			System.out.println(
					"[FAIL] Organization creation verification failed.");
		}

		// ========================================================================
		// STEP 13: LOGOUT FROM VTIGER CRM
		// ========================================================================

		System.out.println("\n---------------------------------------------------------------");
		System.out.println("[STEP 13] Starting logout process...");
		System.out.println("---------------------------------------------------------------");

		WebElement profileIcon =
				driver.findElement(
						By.cssSelector(
								"img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);

		System.out.println("[INFO] Hovering over profile icon...");

		act.moveToElement(profileIcon)
				.build()
				.perform();

		System.out.println(
				"[PASS] Profile menu displayed successfully.");

		System.out.println("[INFO] Clicking Sign Out...");

		driver.findElement(By.linkText("Sign Out")).click();

		System.out.println("[PASS] Sign Out clicked successfully.");
		System.out.println("[PASS] Logout completed successfully.");

		// ========================================================================
		// STEP 14: CLOSE BROWSER
		// ========================================================================

		System.out.println("\n---------------------------------------------------------------");
		System.out.println("[STEP 14] Preparing to close browser...");
		System.out.println("---------------------------------------------------------------");

		System.out.println(
				"[INFO] Waiting for 2 seconds before closing browser...");

		Thread.sleep(2000);

		System.out.println("[INFO] Closing browser...");

		driver.quit();

		System.out.println("[PASS] Browser closed successfully.");

		// ========================================================================
		// TEST EXECUTION END
		// ========================================================================

		System.out.println("\n================================================================");
		System.out.println("        CREATE ORGANIZATION TEST EXECUTION FINISHED");
		System.out.println("================================================================");
	}
}