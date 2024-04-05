import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		// End to End  project
				System.setProperty("webdriverchrome.driver", "C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
				// chromedriver
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//				driver.get("https://www.spicejet.com/");
				
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				Thread.sleep(3000);
				
				// From City
				driver.findElement(By.xpath("*//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//a[@value='DEL']")).click();
				Thread.sleep(3000);
				
				// To City
				
				// use this parent child relationship
				driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

				 Thread.sleep(3000);
				// Validate Calendar from to Date -- To date is disabled
				 
				 // From date pick current one - use css Selector with class .
				 driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
				 Thread.sleep(3000);
				 
				 
				 if (driver.findElement(By.id("Div1")).getAttribute("Style").contains("0.5"))
					{
						System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));
						System.out.println("is disabled");
						Assert.assertTrue(true);
					}else {
						System.out.println("is Enabled");
						Assert.assertTrue(false);
					};
				
					Thread.sleep(4000L);
					driver.findElement(By.id("divpaxinfo")).click();
					
					// book adult 5 passengers using for loop
					
					for (int i=1;i<5;i++) {
						driver.findElement(By.id("hrefIncAdt")).click();  //click 4 times
					};
					
					//
					
					driver.findElement(By.id("btnclosepaxoption")).click();
					
					Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
				    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				    
				 // Css selector - tag and attribute with regular expression * regular
					Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
					
					driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
					
					System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
					Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
					//Thread.sleep(5000);
					
					// Search Button
					
					//driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
					driver.findElement(By.cssSelector("input[value='Search']")).click();
					// driver.findElement(By.xpath("//input[@value='Search']")).click();
					// driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();
	}

}
