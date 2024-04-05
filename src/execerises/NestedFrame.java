package execerises;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NestedFrame {

	public static void main(String[] args) throws InterruptedException {

//		print nested frame
		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://the-internet.herokuapp.com/");

		Actions a = new Actions(driver);
		WebElement parentNode = driver.findElement(By.cssSelector("div[id='content'] ul"));

		List<WebElement> nodes = parentNode.findElements(By.tagName("li"));
		for (WebElement node : nodes) {
			if (node.getText().contains("Nested")) {
				System.out.println(node.getText());
				Thread.sleep(1000);
				node.findElement(By.cssSelector("a")).click();
				break;
			}
		}

		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.cssSelector("frameset frame")));
		// driver.switchTo().frame(0);
		System.out.println(driver.findElements(By.cssSelector("frame")).size());
		driver.switchTo().frame(1);
		System.out.println("in");

		System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());

		// switch back to Web page to continue or choose another frame or object
		driver.switchTo().defaultContent();
	}

}
