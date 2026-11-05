package sauce_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemoTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.saucedemo.com/");
		
		WebElement usernameFiled= driver.findElement(By.id("user-name"));
		
		usernameFiled.sendKeys("visual_user");
		WebElement passwordField= driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");
				
		WebElement login_Button= driver.findElement(By.id("login-button"));
		login_Button.click();
		
		WebElement addToCartButton= driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
		addToCartButton.click();
		
		driver.findElement(By.className("shopping_cart_link")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		driver.findElement(By.id("first-name")).sendKeys("Supriya");
		driver.findElement(By.id("last-name")).sendKeys("Gagan");
		driver.findElement(By.id("postal-code")).sendKeys("110096");
		
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("finish")).click();
		
		driver.findElement(By.id("back-to-products")).click();
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}
