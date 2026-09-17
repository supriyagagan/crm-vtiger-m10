package troubleTicket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * ============================================================================
 * Class Name    : CreateTroubleTkt
 * Package       : troubleTicket
 * Description   :
 *     This automation script creates a new Trouble Ticket in the application,
 *     verifies that the ticket has been created successfully, logs out from
 *     the application, and finally closes the browser.
 *
 * Application  : Local CRM Application
 * Browser      : Google Chrome
 * Automation   : Selenium WebDriver
 *
 * Test Flow:
 *     1. Launch Chrome browser
 *     2. Maximize browser window
 *     3. Configure implicit wait
 *     4. Navigate to application login page
 *     5. Enter valid username and password
 *     6. Click Login
 *     7. Navigate to Trouble Tickets
 *     8. Click Create Ticket
 *     9. Generate a unique Trouble Ticket title
 *    10. Enter ticket title
 *    11. Save the Trouble Ticket
 *    12. Capture the actual ticket title
 *    13. Compare expected and actual ticket title
 *    14. Display PASS/FAIL result
 *    15. Logout from application
 *    16. Wait for 2 seconds
 *    17. Close browser
 *
 * Expected Result:
 *     The Trouble Ticket should be created successfully and the actual
 *     ticket title should match the generated ticket title.
 *
 * ============================================================================
 */
public class CreateTroubleTkt {

    /**
     * Main method used to execute the Trouble Ticket creation test.
     *
     * @param args command line arguments
     * @throws InterruptedException when Thread.sleep() is interrupted
     */
    public static void main(String[] args) throws InterruptedException {

        System.out.println("======================================================");
        System.out.println("        CREATE TROUBLE TICKET TEST STARTED");
        System.out.println("======================================================");

        // --------------------------------------------------------------------
        // STEP 1: Launch Chrome Browser
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 1: Launching Chrome browser...");

        WebDriver driver = new ChromeDriver();

        System.out.println("[INFO] Chrome browser launched successfully.");

        // --------------------------------------------------------------------
        // STEP 2: Maximize Browser Window
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 2: Maximizing browser window...");

        driver.manage().window().maximize();

        System.out.println("[INFO] Browser window maximized successfully.");

        // --------------------------------------------------------------------
        // STEP 3: Configure Implicit Wait
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 3: Configuring implicit wait of 15 seconds...");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        System.out.println("[INFO] Implicit wait configured successfully.");

        // --------------------------------------------------------------------
        // STEP 4: Navigate to Application Login Page
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 4: Navigating to application login page...");

        driver.get("http://localhost:8888/index.php?action=Login&module=Users");

        System.out.println("[INFO] Login page opened successfully.");

        // --------------------------------------------------------------------
        // STEP 5: Locate Login Page Elements
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 5: Locating username, password and login button...");

        WebElement username = driver.findElement(By.name("user_name"));
        WebElement password = driver.findElement(By.name("user_password"));
        WebElement loginbtn = driver.findElement(By.id("submitButton"));

        System.out.println("[INFO] Login page elements located successfully.");

        // --------------------------------------------------------------------
        // STEP 6: Enter Login Credentials
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 6: Entering username...");

        username.sendKeys("admin");

        System.out.println("[INFO] Username entered successfully.");

        System.out.println("[INFO] Entering password...");

        password.sendKeys("manager");

        System.out.println("[INFO] Password entered successfully.");

        // --------------------------------------------------------------------
        // STEP 7: Click Login Button
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 7: Clicking Login button...");

        loginbtn.click();

        System.out.println("[INFO] Login button clicked successfully.");

        // --------------------------------------------------------------------
        // STEP 8: Navigate to Trouble Tickets
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 8: Navigating to Trouble Tickets module...");

        driver.findElement(By.linkText("Trouble Tickets")).click();

        System.out.println("[INFO] Trouble Tickets module opened successfully.");

        // --------------------------------------------------------------------
        // STEP 9: Click Create Ticket
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 9: Clicking Create Ticket option...");

        driver.findElement(
                By.cssSelector("img[title='Create Ticket...']")
        ).click();

        System.out.println("[INFO] Create Trouble Ticket page opened successfully.");

        // --------------------------------------------------------------------
        // STEP 10: Generate Unique Trouble Ticket Name
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 10: Generating unique Trouble Ticket name...");

        String tickt = "tt_" + System.currentTimeMillis();

        System.out.println("[INFO] Generated Trouble Ticket Name: " + tickt);

        // --------------------------------------------------------------------
        // STEP 11: Enter Trouble Ticket Title
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 11: Locating Trouble Ticket title field...");

        WebElement titlefield =
                driver.findElement(By.name("ticket_title"));

        System.out.println("[INFO] Trouble Ticket title field located successfully.");

        System.out.println("[INFO] Entering Trouble Ticket title...");

        titlefield.sendKeys(tickt);

        System.out.println("[INFO] Trouble Ticket title entered successfully.");

        // --------------------------------------------------------------------
        // STEP 12: Save Trouble Ticket
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 12: Saving Trouble Ticket...");

        driver.findElement(
                By.cssSelector("input[title='Save [Alt+S]']")
        ).click();

        System.out.println("[INFO] Trouble Ticket save operation completed.");

        // --------------------------------------------------------------------
        // STEP 13: Verify Trouble Ticket Creation
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 13: Starting Trouble Ticket creation verification...");

        String acttickt =
                driver.findElement(By.id("dtlview_Title")).getText();

        System.out.println("[INFO] Expected Trouble Ticket Name : " + tickt);
        System.out.println("[INFO] Actual Trouble Ticket Name   : " + acttickt);

        // --------------------------------------------------------------------
        // STEP 14: Compare Expected and Actual Ticket Name
        // --------------------------------------------------------------------
        if (acttickt.equals(tickt)) {

            System.out.println("[PASS] Trouble Ticket created successfully.");
            System.out.println("[PASS] Expected and Actual ticket names are matching.");

        } else {

            System.out.println("[FAIL] Failed to create Trouble Ticket.");
            System.out.println("[FAIL] Expected and Actual ticket names are NOT matching.");

        }

        // --------------------------------------------------------------------
        // STEP 15: Start Logout Process
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 15: Starting logout process...");

        WebElement profileIcon =
                driver.findElement(
                        By.cssSelector("img[src='themes/softed/images/user.PNG']")
                );

        // --------------------------------------------------------------------
        // STEP 16: Hover Over Profile Icon
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 16: Hovering over profile icon...");

        Actions act = new Actions(driver);

        act.moveToElement(profileIcon)
           .build()
           .perform();

        System.out.println("[INFO] Profile menu displayed successfully.");

        // --------------------------------------------------------------------
        // STEP 17: Click Sign Out
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 17: Clicking Sign Out...");

        driver.findElement(By.linkText("Sign Out")).click();

        System.out.println("[INFO] Logout completed successfully.");

        // --------------------------------------------------------------------
        // STEP 18: Wait Before Closing Browser
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 18: Waiting for 2 seconds before closing browser...");

        Thread.sleep(2000);

        // --------------------------------------------------------------------
        // STEP 19: Close Browser
        // --------------------------------------------------------------------
        System.out.println("[INFO] Step 19: Closing browser...");

        driver.quit();

        System.out.println("[INFO] Browser closed successfully.");

        // --------------------------------------------------------------------
        // TEST COMPLETION
        // --------------------------------------------------------------------
        System.out.println("======================================================");
        System.out.println("       CREATE TROUBLE TICKET TEST FINISHED");
        System.out.println("======================================================");
    }
}