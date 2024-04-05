import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

// TestNG - is one of the testing framework

public class UpdateDropdow {

	public static void main(String[] args) throws InterruptedException {
		// update dropdown 
		
		System.setProperty("webdriverchrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Css selector - tag and attribute with regular expression * regular
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Thread.sleep(3000);
		
		
		//dates status
		
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));
		//radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Thread.sleep(3000);
		//enabled style="display: block; opacity: 1;" xpath="1"
		// unabled - style="display: block; opacity: 0.5;" xpath="1"
		if (driver.findElement(By.id("Div1")).getAttribute("Style").contains("1"))
		{
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));
			System.out.println("is Enabled");
			Assert.assertTrue(true);
		}else {
			System.out.println("is Enabled");
			Assert.assertTrue(false);
		};
		
		
		// End date 
		
		
		Thread.sleep(3000);
		//count number of checkbox using getsize();
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
				
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		// book adult 4 using for loop
		
		for (int i=1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();  //click 4 times
		};
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	
		
	}

}
