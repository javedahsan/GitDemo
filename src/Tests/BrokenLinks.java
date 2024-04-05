package Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class BrokenLinks {

	public static void main(String[] args) throws IOException, InterruptedException  { 
		// TODO Auto-generated method stub
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		/*
		 * Broken links Step1: IS to get all urls tied up to the links using Selenium
		 * JAVA methods will call URL's and gets you the status code if status code >
		 * 400 then url is not working --> link which tied to url is broken
		 * //a[href*="soapui"
		 */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
//		String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
//		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		 WebElement parentNode = driver.findElement(By.cssSelector("div[id='gf-BIG']"));
		
		List <WebElement>childNodes = parentNode.findElements(By.cssSelector("a[href"));
		
		SoftAssert a = new SoftAssert();
		
		for (  WebElement childNode : childNodes) {
			String url = childNode.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			
			System.out.println(respCode);
			//Assert is hard insertion - it quit at condition true
			// use soft Assertion
			a.assertTrue(respCode<400,"The link with Text " + childNode.getText() + " is broken with Code " + respCode );
			}
		}
		 
		
	}


