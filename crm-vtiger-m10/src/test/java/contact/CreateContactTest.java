package contact;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * =====================================================================
 * Test Script Name : CreateContactTest
 * =====================================================================
 *
 * Application      : Vtiger CRM
 * Module           : Contacts
 * Test Type        : Functional UI Automation
 * Automation Tool  : Selenium WebDriver
 * Programming Lang : Java
 * Browser          : Google Chrome
 *
 * =====================================================================
 * DESCRIPTION
 * =====================================================================
 *
 * This automation script verifies the creation of a new Contact
 * in the Vtiger CRM application.
 *
 * The script performs the complete Contact creation flow starting
 * from launching the browser and logging into the application.
 *
 * After successful login, the script navigates to the Contacts module,
 * opens the Create Contact page, enters the Contact Last Name,
 * selects the Lead Source, enters Email, Assistant and Date of Birth,
 * and saves the Contact.
 *
 * After saving, the script captures the Last Name displayed on the
 * Contact details page and compares it with the Last Name entered
 * during Contact creation.
 *
 * Finally, the script logs out from the Vtiger CRM application
 * and closes the browser.
 *
 * =====================================================================
 * TEST OBJECTIVE
 * =====================================================================
 *
 * To verify that:
 *
 * 1. User can successfully launch the Vtiger CRM application.
 * 2. User can login using valid credentials.
 * 3. User can navigate to the Contacts module.
 * 4. User can open the Create Contact page.
 * 5. User can enter the Contact Last Name.
 * 6. User can select the Lead Source.
 * 7. User can enter Email, Assistant and Date of Birth.
 * 8. User can save the Contact successfully.
 * 9. The created Contact displays the correct Last Name.
 * 10. Expected and Actual Last Names are matching.
 * 11. User can successfully logout from the application.
 *
 * =====================================================================
 * TEST FLOW
 * =====================================================================
 *
 * Step 1  : Launch Chrome browser.
 * Step 2  : Maximize the browser window.
 * Step 3  : Configure implicit wait of 15 seconds.
 * Step 4  : Navigate to Vtiger CRM application.
 * Step 5  : Login using valid credentials.
 * Step 6  : Navigate to Contacts module.
 * Step 7  : Open Create Contact page.
 * Step 8  : Prepare Contact test data.
 * Step 9  : Enter Contact Last Name and additional Contact details.
 * Step 10 : Save Contact.
 * Step 11 : Capture Actual Last Name.
 * Step 12 : Compare Expected and Actual Last Name.
 * Step 13 : Logout from Vtiger CRM.
 * Step 14 : Wait for 2 seconds and close browser.
 *
 * =====================================================================
 * TEST DATA
 * =====================================================================
 *
 * Username          : admin
 * Password          : manager
 * Contact Last Name : Sharma
 * Lead Source       : Employee
 * Email             : supriyagagan1992@gmail.com
 * Assistant         : acvfrth
 * Date of Birth     : 1997-02-26
 *
 * =====================================================================
 * EXPECTED RESULT
 * =====================================================================
 *
 * The Contact should be created successfully.
 *
 * The Last Name displayed on the Contact details page should match
 * the Last Name entered during Contact creation.
 *
 * =====================================================================
 * VERIFICATION LOGIC
 * =====================================================================
 *
 * Expected Last Name = Actual Last Name
 *
 * If both values are equal:
 *      Test Result = PASS
 *
 * If both values are not equal:
 *      Test Result = FAIL
 *
 * =====================================================================
 * AUTHOR
 * =====================================================================
 *
 * AutomationWithPiyush
 *
 * =====================================================================
 */
public class CreateContactTest {

	/**
	 * Main method responsible for executing the complete
	 * Create Contact automation flow.
	 *
	 * @param args command-line arguments
	 * @throws InterruptedException if thread execution is interrupted
	 */
	public static void main(String[] args) throws InterruptedException {

		// ================================================================
		// TEST EXECUTION START
		// ================================================================

		System.out.println("==============================================================");
		System.out.println("              CREATE CONTACT TEST EXECUTION STARTED");
		System.out.println("==============================================================");

		// ----------------------------------------------------------------
		// STEP 1: Launch Chrome Browser
		// ----------------------------------------------------------------

		System.out.println("[STEP 1] Launching Chrome browser...");

		WebDriver driver = new ChromeDriver();

		System.out.println("[PASS] Chrome browser launched successfully.");

		// ----------------------------------------------------------------
		// STEP 2: Maximize Browser Window
		// ----------------------------------------------------------------

		System.out.println("[STEP 2] Maximizing browser window...");

		driver.manage().window().maximize();

		System.out.println("[PASS] Browser window maximized successfully.");

		// ----------------------------------------------------------------
		// STEP 3: Configure Implicit Wait
		// ----------------------------------------------------------------

		System.out.println("[STEP 3] Configuring implicit wait...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		System.out.println("[PASS] Implicit wait configured to 15 seconds.");

		// ----------------------------------------------------------------
		// STEP 4: Navigate to Vtiger CRM Application
		// ----------------------------------------------------------------

		System.out.println("[STEP 4] Navigating to Vtiger CRM application...");

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		System.out.println("[PASS] Vtiger CRM login page opened successfully.");

		// ================================================================
		// LOGIN SECTION
		// ================================================================

		// ----------------------------------------------------------------
		// STEP 5: Login to Vtiger CRM
		// ----------------------------------------------------------------

		System.out.println("--------------------------------------------------------------");
		System.out.println("[STEP 5] Starting Vtiger CRM login process...");
		System.out.println("--------------------------------------------------------------");

		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement loginButton = driver.findElement(By.id("submitButton"));

		System.out.println("[INFO] Login page elements located successfully.");

		System.out.println("[INFO] Entering username...");

		username.sendKeys("admin");

		System.out.println("[PASS] Username entered successfully.");

		System.out.println("[INFO] Entering password...");

		password.sendKeys("manager");

		System.out.println("[PASS] Password entered successfully.");

		System.out.println("[INFO] Clicking Login button...");

		loginButton.click();

		System.out.println("[PASS] Login button clicked successfully.");
		System.out.println("[PASS] Login process completed successfully.");

		// ================================================================
		// CONTACT CREATION SECTION
		// ================================================================

		// ----------------------------------------------------------------
		// STEP 6: Navigate to Contacts Module
		// ----------------------------------------------------------------

		System.out.println("--------------------------------------------------------------");
		System.out.println("[STEP 6] Navigating to Contacts module...");
		System.out.println("--------------------------------------------------------------");

		driver.findElement(By.linkText("Contacts")).click();

		System.out.println("[PASS] Contacts module opened successfully.");

		// ----------------------------------------------------------------
		// STEP 7: Open Create Contact Page
		// ----------------------------------------------------------------

		System.out.println("[STEP 7] Opening Create Contact page...");

		driver.findElement(
				By.cssSelector("img[title='Create Contact...']"))
				.click();

		System.out.println("[PASS] Create Contact page opened successfully.");

		// ----------------------------------------------------------------
		// STEP 8: Define Contact Last Name
		// ----------------------------------------------------------------

		System.out.println("[STEP 8] Preparing Contact test data...");

		String lastName = "Sharma";

		System.out.println("[INFO] Contact Last Name : " + lastName);
		System.out.println("[PASS] Contact test data prepared successfully.");

		// ----------------------------------------------------------------
		// STEP 9: Enter Contact Last Name
		// ----------------------------------------------------------------

		System.out.println("[STEP 9] Locating Contact Last Name field...");

		WebElement lastNameField = driver.findElement(By.name("lastname"));

		System.out.println("[INFO] Entering Contact Last Name...");

		lastNameField.sendKeys(lastName);

		System.out.println("[PASS] Contact Last Name entered successfully.");

		// ----------------------------------------------------------------
		// Select Lead Source
		// ----------------------------------------------------------------

		System.out.println("[INFO] Locating Lead Source dropdown...");

		WebElement leadSource = driver.findElement(By.name("leadsource"));

		Select selSingle = new Select(leadSource);

		System.out.println("[INFO] Selecting Lead Source: Employee...");

		selSingle.selectByValue("Employee");

		System.out.println("[PASS] Lead Source selected successfully.");

		System.out.println("[INFO] Displaying available Lead Source options...");

		List<WebElement> options = selSingle.getOptions();

		for (WebElement i : options) {

			System.out.println("[OPTION] " + i.getText());
		}

		System.out.println("[PASS] Lead Source options displayed successfully.");

		// ----------------------------------------------------------------
		// Enter Email and Assistant
		// ----------------------------------------------------------------

		System.out.println("[INFO] Locating Email field...");

		WebElement email = driver.findElement(By.id("email"));

		System.out.println("[INFO] Locating Assistant field...");

		WebElement assistant = driver.findElement(By.id("assistant"));

		System.out.println("[INFO] Entering Email Address...");

		email.sendKeys("supriyagagan1992@gmail.com");

		System.out.println("[PASS] Email Address entered successfully.");

		System.out.println("[INFO] Entering Assistant information...");

		assistant.sendKeys("acvfrth");

		System.out.println("[PASS] Assistant information entered successfully.");

		// ----------------------------------------------------------------
		// Enter Date of Birth
		// ----------------------------------------------------------------

		System.out.println("[INFO] Locating Date of Birth field...");

		WebElement dob = driver.findElement(
				By.id("jscal_field_birthday"));

		System.out.println("[INFO] Entering Date of Birth...");

		dob.sendKeys("1997-02-26");

		System.out.println("[PASS] Date of Birth entered successfully.");

		// ----------------------------------------------------------------
		// STEP 10: Save Contact
		// ----------------------------------------------------------------

		System.out.println("--------------------------------------------------------------");
		System.out.println("[STEP 10] Saving Contact...");
		System.out.println("--------------------------------------------------------------");

		driver.findElement(
				By.cssSelector("input[title='Save [Alt+S]']"))
				.click();

		System.out.println("[PASS] Save button clicked successfully.");
		System.out.println("[PASS] Contact save operation completed successfully.");

		// ================================================================
		// VERIFICATION SECTION
		// ================================================================

		// ----------------------------------------------------------------
		// STEP 11: Verify Contact Creation
		// ----------------------------------------------------------------

		System.out.println("--------------------------------------------------------------");
		System.out.println("[STEP 11] Starting Contact creation verification...");
		System.out.println("--------------------------------------------------------------");

		String actLastName = driver
				.findElement(By.id("dtlview_Last Name"))
				.getText();

		System.out.println("[INFO] Contact details page loaded successfully.");

		System.out.println("[INFO] Expected Last Name : " + lastName);
		System.out.println("[INFO] Actual Last Name   : " + actLastName);

		// ----------------------------------------------------------------
		// STEP 12: Compare Expected and Actual Last Name
		// ----------------------------------------------------------------

		System.out.println("[STEP 12] Comparing expected and actual Last Name...");

		if (actLastName.equals(lastName)) {

			System.out.println("[PASS] Contact Created Successfully.");
			System.out.println("[PASS] Expected and Actual Last Names match.");
			System.out.println("[PASS] Contact creation verification completed successfully.");

		}

		// ================================================================
		// LOGOUT SECTION
		// ================================================================

		// ----------------------------------------------------------------
		// STEP 13: Logout from Vtiger CRM
		// ----------------------------------------------------------------

		System.out.println("--------------------------------------------------------------");
		System.out.println("[STEP 13] Starting logout process...");
		System.out.println("--------------------------------------------------------------");

		WebElement profileIcon = driver.findElement(
				By.cssSelector(
						"img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);

		System.out.println("[INFO] Hovering over profile icon...");

		act.moveToElement(profileIcon).build().perform();

		System.out.println("[PASS] Profile menu interaction completed successfully.");

		System.out.println("[INFO] Clicking Sign Out...");

		driver.findElement(By.linkText("Sign Out")).click();

		System.out.println("[PASS] Sign Out clicked successfully.");
		System.out.println("[PASS] Logout completed successfully.");

		// ================================================================
		// BROWSER CLOSURE SECTION
		// ================================================================

		// ----------------------------------------------------------------
		// STEP 14: Close Browser
		// ----------------------------------------------------------------

		System.out.println("--------------------------------------------------------------");
		System.out.println("[STEP 14] Preparing to close browser...");
		System.out.println("--------------------------------------------------------------");

		System.out.println("[INFO] Waiting for 2 seconds before closing browser...");

		Thread.sleep(2000);

		System.out.println("[INFO] Closing browser...");

		driver.quit();

		System.out.println("[PASS] Browser closed successfully.");

		// ================================================================
		// TEST EXECUTION END
		// ================================================================

		System.out.println("==============================================================");
		System.out.println("              CREATE CONTACT TEST EXECUTION FINISHED");
		System.out.println("==============================================================");
	}
}

