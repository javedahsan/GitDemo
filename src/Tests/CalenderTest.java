package Tests;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderTest {

	public static void main(String[] args) throws InterruptedException {
		// validate given date in calendar
		String monthNumber = "6";
		String dayNumber = "15";
		String year = "2027";
		String[] expectedList = { monthNumber, dayNumber, year };

		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(monthNumber) - 1).click();
		driver.findElement(By.xpath("//abbr[text()='" + dayNumber + "']")).click();
		
		// capture results
		// below line will print only //
//		System.out.print(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());

		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

		for (int i = 0; i < actualList.size(); i++) {
			System.out.println(actualList.get(i).getAttribute("value"));
			
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}
		
		driver.close();
		driver.quit();

	}

}
