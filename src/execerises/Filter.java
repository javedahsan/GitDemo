package execerises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Filter {

	public static void main(String[] args) throws InterruptedException {
		// filter the list of item using search button
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.getTitle();

		Thread.sleep(3000);
		
		// above
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		//System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameEditBox)).getText());
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
	    //below
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
	    driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
	    
	    //toLeftOf
	    WebElement leftCheck1nameEditBox = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
	    driver.findElement(with(By.tagName("input")).toLeftOf(leftCheck1nameEditBox)).click();
	    
	    //toRightOf
	    WebElement rdb = driver.findElement(By.id("inlineRadio1"));
	    System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
	    
	}

}
