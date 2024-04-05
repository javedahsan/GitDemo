package Tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		
		// windows handles - capture email address from child window and insert into parent window
		
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//click on child window link - use class attribute
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		// get window handles
		
		Set <String> windows = driver.getWindowHandles(); //parentId, childId, or subchildId
		// read windows object with iterator 
		
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		
		//switch to child window
		driver.switchTo().window(childId);
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		// swith to parent window
		driver.switchTo().window(parentId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailId);
//		<p class="im-para red">Please email us at <strong><a 

	}

}
