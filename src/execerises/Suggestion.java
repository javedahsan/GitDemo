package execerises;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Suggestion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * Suggestion dropdown - input first letter and select the country from list
		 * make sure country is displayed in suggested box
		 */

		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions a = new Actions(driver);
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		List <WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		// search index one by one and until you find india
				for (WebElement option : options) {
					if (option.getText().equalsIgnoreCase("india"))
					{
						option.click();
						break;
					}
				}
				
				// 
				Thread.sleep(3000);
				System.out.println(driver.findElement(By.id("autocomplete")).isDisplayed());
				System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
				
		
	}

}
