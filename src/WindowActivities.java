import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// Managing window with maximum mode
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://google.com"); // selenium will wait until  fully loaded
		
		//navigate to anothter url
		
		driver.navigate().to("https://rahulshettyacademy.com"); // selenium will to wait to load - handle with implecit or explicit wait
		
		
		//go back to google.com
		
		driver.navigate().back();
		System.out.println("go back to google");
		
		driver.navigate().forward();
		System.out.println("go forward to rahulShetty");

	}

}
