package email;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEmailTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Email']")).click();
		
		
WebElement compose=driver.findElement(By.xpath("//a[text()='Compose']"));


compose.click();
Thread.sleep(1000);
String pid = driver.getWindowHandle();
Set<String> oldWindow=driver.getWindowHandles();

for(String windowHandle:oldWindow) {
	if(!windowHandle.equals(pid)) {
		
		driver.switchTo().window(windowHandle);
		break;
	}	
}
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.numberOfWindowsToBe(2));
System.out.println(driver.getTitle());


WebElement contact=driver.findElement(By.xpath("//img[@title='Select']"));
contact.click();


Set<String> allWindow=driver.getWindowHandles();

for(String window:allWindow) {
	if(!oldWindow.contains(window)) {
		
		driver.switchTo().window(window);
		break;
	}	
}
WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
wait1.until(ExpectedConditions.numberOfWindowsToBe(3));
System.out.println(driver.getTitle());


driver.findElement(By.xpath("//a[text()='Mary Smith']")).click();

Set<String> newwindow=driver.getWindowHandles();

for(String windowHandle1:newwindow) {
	if(!windowHandle1.equals(pid)) {
		
		driver.switchTo().window(windowHandle1);
		break;
	}	
}


driver.findElement(By.id("subject")).sendKeys("test vtiger");

driver.findElement(By.name("Send")).click();
Thread.sleep(4000);
driver.quit();

		
}

}

