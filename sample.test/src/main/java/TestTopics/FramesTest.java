package TestTopics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FramesTest {

	static WebDriver driver;
	static String baseurl = "https://demoqa.com/frames";

	@BeforeTest
	public static void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void frames() {

		driver.switchTo().frame("frame1");
		WebElement firstFrame = driver.findElement(By.id("sampleHeading"));
		String firstString = firstFrame.getText();
		System.out.println(firstString);

		driver.switchTo().frame("frame2");
		WebElement secondFrame = driver.findElement(By.id("sampleHeading"));
		String secondString = secondFrame.getText();
		System.out.println(secondString);
		
		List<WebElement> frameList = driver.findElements(By.tagName("frames"));
		System.out.println(frameList.size());
	}
				
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
