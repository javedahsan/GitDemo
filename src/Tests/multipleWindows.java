package Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class multipleWindows {

	public static void main(String[] args) throws InterruptedException, IOException {
		// open 2 windows and capture text from 2nd window
		// write text into input field in the first window
		// parentWindow - https://rahulshettyacademy.com/angularpractice/
		// child window https://rahulshettyacademy.com
		// run the test with TAB and WINDOW

		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// capture windowTypes - TAB
		//driver.switchTo().newWindow(WindowType.TAB);
		
		// try with WINDOW
				driver.switchTo().newWindow(WindowType.WINDOW);
				

		// capture window handles
		Set<String> handles = driver.getWindowHandles();

		// use iterator to find how many windows are open
		Iterator<String> it = handles.iterator();

		// switch the handle - first next on parent and 2nd next on Child

		String parentWindowId = it.next();

		String childWindowId = it.next();

		// switch driver to child window
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(3000);
		
		List<WebElement> courseNames = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
		String course = courseNames.stream().map(s->s.getText()).collect(Collectors.toList()).get(1);
		System.out.println(course);
		
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(course);

		// capture screenshot with Selenium 4
		
		File fileName = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileName, new File("C:\\Introduction\\screenShots\\screen1.png"));
		
		// capture height and width
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		driver.quit();

	}

}
