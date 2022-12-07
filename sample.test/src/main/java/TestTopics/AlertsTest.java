package TestTopics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertsTest {
	static WebDriver driver;
	static String baseurl = "https://demoqa.com/alerts";

	@BeforeTest
	public static void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(priority = 1)
	public void AlertTest() {
		WebElement alertBtnElement = driver.findElement(By.id("alertButton"));
		alertBtnElement.click();
		driver.switchTo().alert().accept();
	}

	@Test(priority = 2)
	public void dealayAlertTest() {
		WebElement timealertElement = driver.findElement(By.id("timerAlertButton"));
		timealertElement.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	@Test(priority = 3)
	public void confirmAlertTest() {
		WebElement confirmElement = driver.findElement(By.id("confirmButton"));
		confirmElement.click();
		driver.switchTo().alert().dismiss();
	}

	@Test(priority = 4)
	public void promptAlertTest() {
		WebElement promtalertElement = driver.findElement(By.id("promtButton"));
		promtalertElement.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Test");
		alert.accept();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}


