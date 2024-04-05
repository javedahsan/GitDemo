package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		// frame test
		// frame by index, by argument or WebElement
		
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/droppable/");
		
		//note by index - use 0 first frame 
		System.out.println(driver.findElements(By.tagName("iframe")).size());
//		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		
		//drag and drop
		Actions a = new Actions(driver);
		WebElement sourceId = driver.findElement(By.id("draggable"));
		WebElement targetId= driver.findElement(By.id("droppable"));
		a.dragAndDrop(sourceId, targetId).build().perform();
		
		//switch back to Webpage to continue or choose another frame or object
		driver.switchTo().defaultContent();
		
	}

}
