import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ExSelectoption {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/AutomationPractice/
		// 1. Select any checkbox
		// Grab the label of the selected checkbox
		// Select and option in dropdown , here the option should be selected from
		// option 2

		System.setProperty("webdriverchrome.driver",
				"C:\\Users\\user\\DevTools\\WbDrivers\\chromedriver-win64\\chromedriver.exe");
		// chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Thread.sleep(2000);
		WebElement checkBoxoptions = driver.findElement(By.id("checkbox-example"));

		List<WebElement> options = checkBoxoptions.findElements(By.cssSelector("label input"));

		String selectedValue = null;
		for (int i = 0; i < options.size(); i++) {

			System.out.println(options.get(i).getText());
			selectedValue = options.get(i).getText();
			options.get(i).click();

			// select Element

			Thread.sleep(1000);
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.id("dropdown-class-example"))).click().keyDown(Keys.ARROW_DOWN)
					.sendKeys(selectedValue).click().build().perform();

			Thread.sleep(1000);
			System.out.println("Selected Option: " + selectedValue + " " + driver.findElement(By.cssSelector("select[id='dropdown-class-example']")).isDisplayed());
			options.get(i).click();
		}
		driver.close();
		driver.quit();

	}

}
