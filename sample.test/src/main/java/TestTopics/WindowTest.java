package TestTopics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowTest {
	static WebDriver driver;
	static String baseurl = "https://demoqa.com/browser-windows";

	@BeforeTest
	public static void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@SuppressWarnings("static-access")
	@Test
	public void newTabTest() throws InterruptedException {
		WebElement btn = driver.findElement(By.id("tabButton"));
		btn.click();
		btn.sendKeys(Keys.CONTROL.TAB);
		Thread.sleep(Duration.ofSeconds(3));
		btn.sendKeys(Keys.CONTROL.SHIFT.TAB);
	}

	@Test
	public void newWindowTest() {

		// Store the ID of the original window
		String mainWindow = driver.getWindowHandle();

		// Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 2;

		// Click the link which opens in a new window
		WebElement btn = driver.findElement(By.id("windowButton"));
		btn.click();

		// Loop through until we find a new window handle
		for (String windString : driver.getWindowHandles()) {

			if (!mainWindow.contentEquals(windString)) {
				driver.switchTo().window(windString).manage().window().maximize();
				String textString = driver.findElement(By.id("sampleHeading")).getText();
				System.out.println("The Text is get from new window :" + textString);
				break;
			}
		}
	}

	@AfterTest
	public void teatDown() {
		driver.quit();
	}

}
