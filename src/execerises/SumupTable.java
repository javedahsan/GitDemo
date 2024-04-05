package execerises;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SumupTable {

	public static void main(String[] args) throws InterruptedException {
		
		/* sumup price column in the web example table 
		Scroll window or scroll table
		to capture all scroll commands use jquery in console and copy here
		*/
		
				System.setProperty("webdriverchrome.driver",
						"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
				// chromedriver
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				//JS 
				
				JavascriptExecutor	js = (JavascriptExecutor) driver;
				
				// scrolltop 
				
				js.executeScript("document.querySelector('.table-display').scrollTop=5000");
				Thread.sleep(3000);
				
				//1. count number of rows
				List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
				System.out.println(rows.size());
				
				// 2. counts number of columns
				List<WebElement> columns = driver.findElements(By.cssSelector(".table-display tr th"));
				System.out.println(columns.size());
				
				// 2. print context of second counts column
				for (int i=1; i < rows.size();i++) {
					List<WebElement> secondColumn = rows.get(i).findElements(By.xpath("td[2]"));
							for (int j=0; j<secondColumn.size();j++) {
								System.out.println(secondColumn.get(j).getText());
							}
				}
				
				}
				
				
	}

