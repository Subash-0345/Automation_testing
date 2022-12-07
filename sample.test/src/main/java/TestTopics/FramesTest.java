package TestTopics;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FramesTest {

	static WebDriver driver;
	static String baseurl = "https://www.selenium.dev/selenium/docs/api/java/overview-summary.html";

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
		ArrayList<String> lists = new ArrayList<String>();
		WebElement btnElement = driver.findElement(By.xpath("//a[contains(text(),'Frames')]"));
		btnElement.click();

		driver.switchTo().frame("packageListFrame");
		WebElement linkElement = driver
				.findElement(By.xpath("//a[contains(text(),'org.openqa.selenium.virtualauthenticator')]"));
		linkElement.click();

		driver.switchTo().frame("packageFrame");
		WebElement linkeElement = driver.findElement(By.xpath("//a[contains(text(),'Credential')]"));
		linkeElement.click();

		driver.switchTo().frame("classFrame");
		String excpString = "https://w3c.github.io/webauthn/#credential-parameters";
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> iterLinks = links.iterator();
		while (iterLinks.hasNext()) {
			String urls = iterLinks.next().getAttribute("href");
			if (urls.equalsIgnoreCase(excpString)){
				Assert.assertEquals(excpString,urls);
				driver.findElement(By.xpath("a[@href="+urls+"]")).click();
			}
		}

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
