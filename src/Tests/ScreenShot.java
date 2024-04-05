package Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		// delete Cookies then click on any link -- it will redirect to login page - verify login url
		
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		driver.manage().deleteAllCookies();
//		driver.manage().deleteCookieNamed("sessionKey"); // ask for cookies name
//		
		driver.get("http://google.com");
		//take screen shot
		
		// first casting driver to take screenshot, getScreenShotAs is visible only when
		// we casting driver
		// below line will take screenshot of Google.com
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// store screen on local file
		 FileUtils.copyFile(src, new File("\\Introduction\\screenShots\\screen.png"));
//		 C:\Users\\user\eclipse-workspace\Introduction\screenShots\screenShots
	}
	

}
