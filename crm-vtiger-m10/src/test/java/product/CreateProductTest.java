package product;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * ============================================================================
 * Class Name    : CreateProductTest
 * Package       : product
 *
 * Description   :
 * This Selenium automation script verifies the creation of a Product
 * in the CRM application.
 *
 * Test Objective:
 * Verify that a new product can be successfully created with the
 * specified product name and that the created product name matches
 * the expected product name.
 *
 * Application   : Local CRM Application
 * Browser       : Google Chrome
 * Automation    : Selenium WebDriver
 *
 * Test Flow:
 * 1. Launch Chrome browser
 * 2. Maximize browser window
 * 3. Configure implicit wait
 * 4. Open application login page
 * 5. Enter username and password
 * 6. Click Login button
 * 7. Navigate to Products module
 * 8. Click Create Product
 * 9. Enter product name
 * 10. Save the product
 * 11. Verify created product name
 * 12. Compare expected and actual product name
 * 13. Display PASS/FAIL result
 * 14. Logout from application
 * 15. Close the browser
 *
 * Expected Result:
 * The product should be created successfully and the actual product
 * name displayed after creation should match the expected product name.
 *
 * ============================================================================
 */

public class CreateProductTest {

    public static void main(String[] args) throws InterruptedException {

        // ====================================================================
        // TEST START
        // ====================================================================

        System.out.println("======================================================");
        System.out.println("          CREATE PRODUCT TEST STARTED");
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

        System.out.println("[INFO] Step 3: Configuring implicit wait for 15 seconds...");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        System.out.println("[INFO] Implicit wait configured successfully.");

        // --------------------------------------------------------------------
        // STEP 4: Navigate to Application Login Page
        // --------------------------------------------------------------------

        System.out.println("[INFO] Step 4: Opening application login page...");

        driver.get("http://localhost:8888/index.php?action=Login&module=Users");

        System.out.println("[INFO] Login page opened successfully.");

        // --------------------------------------------------------------------
        // STEP 5: Locate Login Page Elements
        // --------------------------------------------------------------------

        System.out.println("[INFO] Step 5: Locating login page elements...");

        WebElement username = driver.findElement(By.name("user_name"));

        WebElement password = driver.findElement(By.name("user_password"));

        WebElement loginbtn = driver.findElement(By.id("submitButton"));

        System.out.println("[INFO] Username field located successfully.");
        System.out.println("[INFO] Password field located successfully.");
        System.out.println("[INFO] Login button located successfully.");

        // --------------------------------------------------------------------
        // STEP 6: Enter Login Credentials
        // --------------------------------------------------------------------

        System.out.println("[INFO] Entering username...");

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
        // STEP 8: Navigate to Products Module
        // --------------------------------------------------------------------

        System.out.println("[INFO] Step 8: Navigating to Products module...");

        driver.findElement(By.linkText("Products")).click();

        System.out.println("[INFO] Products module opened successfully.");

        // --------------------------------------------------------------------
        // STEP 9: Click Create Product
        // --------------------------------------------------------------------

        System.out.println("[INFO] Step 9: Clicking Create Product option...");

        driver.findElement(
                By.cssSelector("img[alt = 'Create Product...']")
        ).click();

        System.out.println("[INFO] Create Product page opened successfully.");

        // --------------------------------------------------------------------
        // STEP 10: Enter Product Name
        // --------------------------------------------------------------------

        System.out.println("[INFO] Step 10: Preparing product test data...");

        String productName = "Iphone";

        System.out.println("[INFO] Product Name: " + productName);

        System.out.println("[INFO] Locating Product Name field...");

        WebElement productNameField =
                driver.findElement(By.name("productname"));

        System.out.println("[INFO] Product Name field located successfully.");

        System.out.println("[INFO] Entering Product Name...");

        productNameField.sendKeys(productName);

        System.out.println("[INFO] Product Name entered successfully.");

        // --------------------------------------------------------------------
        // STEP 11: Save Product
        // --------------------------------------------------------------------

        System.out.println("[INFO] Step 11: Saving Product...");

        driver.findElement(
                By.cssSelector("input[title = 'Save [Alt+S]']")
        ).click();

        System.out.println("[INFO] Save button clicked successfully.");
        System.out.println("[INFO] Product save operation completed.");

        // --------------------------------------------------------------------
        // STEP 12: Verify Product Creation
        // --------------------------------------------------------------------

        System.out.println("[INFO] Step 12: Verifying Product creation...");

        String actProductName =
                driver.findElement(
                        By.id("dtlview_Product Name")
                ).getText();

        System.out.println("[INFO] Expected Product Name: " + productName);

        System.out.println("[INFO] Actual Product Name: " + actProductName);

        // --------------------------------------------------------------------
        // STEP 13: Compare Expected and Actual Product Name
        // --------------------------------------------------------------------

        System.out.println("[INFO] Comparing expected and actual Product Name...");

        if (actProductName.equals(productName)) {

            System.out.println("[PASS] Product created successfully.");
            System.out.println("[PASS] Expected and Actual Product Name matched.");

        } else {

            System.out.println("[FAIL] Product Creation failed.");
            System.out.println("[FAIL] Expected and Actual Product Name did not match.");

        }

        // --------------------------------------------------------------------
        // STEP 14: Start Logout Process
        // --------------------------------------------------------------------

        System.out.println("[INFO] Step 14: Starting logout process...");

        WebElement profile = driver.findElement(
                By.cssSelector(
                        "img[src='themes/softed/images/user.PNG']"
                )
        );

        System.out.println("[INFO] Profile icon located successfully.");

        // --------------------------------------------------------------------
        // STEP 15: Create Actions Object
        // --------------------------------------------------------------------

        System.out.println("[INFO] Creating Actions object...");

        Actions act = new Actions(driver);

        System.out.println("[INFO] Actions object created successfully.");

        // --------------------------------------------------------------------
        // STEP 16: Hover Over Profile Icon
        // --------------------------------------------------------------------

        System.out.println("[INFO] Hovering over profile icon...");

        act.moveToElement(profile).build().perform();

        System.out.println("[INFO] Mouse hovered over profile icon.");

        // --------------------------------------------------------------------
        // STEP 17: Click Sign Out
        // --------------------------------------------------------------------

        System.out.println("[INFO] Clicking Sign Out option...");

        driver.findElement(By.linkText("Sign Out")).click();

        System.out.println("[INFO] Sign Out option clicked successfully.");

        System.out.println("[INFO] Logout process completed.");

        // --------------------------------------------------------------------
        // STEP 18: Close Browser
        // --------------------------------------------------------------------

        System.out.println("[INFO] Step 18: Closing the browser...");

        Thread.sleep(2000);

        System.out.println("[INFO] Wait completed.");

        driver.quit();

        System.out.println("[INFO] Browser closed successfully.");

        // ====================================================================
        // TEST END
        // ====================================================================

        System.out.println("======================================================");
        System.out.println("          CREATE PRODUCT TEST FINISHED");
        System.out.println("======================================================");
    }
}
