package execerises;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandlesEx {

	public static void main(String[] args) throws InterruptedException {
		
		// windows handles - capture first text from child window
		// then parent window email address from child window and insert into parent window
		// parent first child then parent
		
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://the-internet.herokuapp.com/");
		
		Actions a = new Actions(driver);
		WebElement parentNode = driver.findElement(By.cssSelector("div[id='content'] ul"));
		
		List <WebElement> nodes = parentNode.findElements(By.tagName("li"));
		for (WebElement node : nodes) {
			if (node.getText().contains("Windows")){
			   System.out.println(node.getText());
			   Thread.sleep(1000);
			   node.findElement(By.cssSelector("a")).click();
			   break;
			}
		}
		
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		Set <String> windows = driver.getWindowHandles(); //parentId, childId, or subchildId
		
		// read windows object with iterator 
		
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next();
				
		//switch to child window
		driver.switchTo().window(childId);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		
		driver.close();
		driver.quit();
	}

}
