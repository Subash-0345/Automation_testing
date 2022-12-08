package TestTopics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DargAndDrop {

	static WebDriver driver;
	String baseUrl = "https://demoqa.com/droppable";

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void test() {

		WebElement fromElement = driver.findElement(By.id("draggable"));
		WebElement toElement = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(fromElement, toElement).build().perform();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
