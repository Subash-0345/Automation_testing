package TestTopics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dynamicPropertiesTest {

	static WebDriver driver;

	@BeforeMethod
	public static void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/dynamic-properties");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Test
	public void testExcute() throws InterruptedException {
		String textString= driver.findElement(By.xpath("//p[contains(text(),'random')]")).getText();
		System.out.println("The Text is :"+textString);
		
		WebElement clickBtn = driver.findElement(By.id("colorChange"));

		String colorValString = clickBtn.getCssValue("color");
		System.out.println("The Color is :" + colorValString);

		WebElement enableBtn = driver.findElement(By.id("enableAfter"));

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'enable')]")));
		Thread.sleep(6000);
		if (enableBtn.isEnabled()) {
			System.out.println("The Button is Enabled");
		} else {
			System.out.println("The Button is Not Enabled");
		}

		WebElement visibleBtn = driver.findElement(By.id("visibleAfter"));
		if (visibleBtn.isDisplayed()) {
			System.out.println("The Button is Visibled");
		} else {
			System.out.println("The Button is Not Visibled");
		}

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
