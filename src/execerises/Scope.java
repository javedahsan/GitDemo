package execerises;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 1. find total links 2. footer links 3. find element in first col in the
		 * footer
		 * 
		 */
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		// limiting driver scope to footer only

		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// 3.
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		// click in each link - check page is open

		int totalLinks = columnDriver.findElements(By.tagName("a")).size();

		for (int i = 0; i < totalLinks; i++) {

			// back button is not good option
			// open all links in each tab using Keys and chord sequence
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			// sendkeys instead of click
			// columnDriver.findElements(By.tagName("a")).get(i).click();
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
		}

			// get the title of each window

			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
		
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

}
