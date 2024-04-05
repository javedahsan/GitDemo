package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// Scroll window or scroll table
		// to capture all scroll commands use jquery in console and copy here
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// JS

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript(null, args)  // 2nd args is optional

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

		// scroll down or up any table within web page for class tableFixHead use
		// document (lowercase). scrollleft etc
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// sumup last column

		// use xpath td[4] or css td:nth-child(4)

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (int i = 0; i < values.size(); i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());

		}
		System.out.println(sum);
		
		//div class="totalAmount"> Total Amount Collected: 296 </div>
		
	  driver.findElement(By.className("totalAmount")).getText();
	int total =  Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());

	Assert.assertEquals(sum, total);
	
	}

}
