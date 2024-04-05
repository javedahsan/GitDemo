import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {

		String text = "Javed";
		// how to handle alter window and messages within Alert
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys(text);
//		<input id="name" name="enter-name" class="inputs" placeholder="Enter Your Name" type="text">
		Thread.sleep(4000L);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(4000L);
		// switch to alert popup window
		System.out.println(driver.switchTo().alert().getText());
		// accept OK or YES button in the alert
		driver.switchTo().alert().accept();

		// handle confirm alert with ok and cancel button
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(4000L);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

	}

}
