import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ExeCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		// Exercise CheckBoxes
		
		System.setProperty("webdriverchrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElement(By.cssSelector("div[id='checkbox-example']")));
		//driver.findElement(By.cssSelector("div[id='checkbox-example'] type='checkbox'"));
		List <WebElement> options = driver.findElements(By.xpath("//div[@id='checkbox-example'] //input[@type='checkbox']"));
		Thread.sleep(2000);
		
		for (WebElement option : options) {
			System.out.println(option.getText());
			
			option.click();
			Thread.sleep(1000);
			Assert.assertTrue(option.isEnabled());
			Thread.sleep(2000);
			//uncheck options
			option.click();
			Assert.assertFalse(option.isSelected());
		}
		
		System.out.println("Count number of checkboxUnable");
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
	}

}
