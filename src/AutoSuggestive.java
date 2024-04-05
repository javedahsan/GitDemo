import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// auto Suggestive 
		
		
		System.setProperty("webdriverchrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List <WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		Thread.sleep(2000);
		
		// search index one by one and until you find india
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india"))
			{
				option.click();
				break;
			}
		}
		

	}

}
