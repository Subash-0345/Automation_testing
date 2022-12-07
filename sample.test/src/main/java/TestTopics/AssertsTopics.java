package TestTopics;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AssertsTopics {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	// This Is Soft Asserts
	@Test(priority = 1)
	public void test() {
		String Actualtitle = driver.getTitle();
		String excpectedTitle = "ToolsQA";
		Assert.assertEquals(excpectedTitle, Actualtitle);
	}

	@Test(priority = 2)
	public void testForNotEqual() {
		String Actualtitle = driver.getTitle();
		String excpectedTitle = "QAtools";
		Assert.assertNotEquals(excpectedTitle, Actualtitle);
	}

	@Test(priority = 3)
	public void testForTrue() {
		boolean verifyTitle = driver.getTitle().equalsIgnoreCase("ToolsQA");
		assertTrue(verifyTitle);
	}

	@Test(priority = 4)
	public void testForFalse() {
		boolean verifyTitle = driver.getTitle().equalsIgnoreCase("QAtools");
		assertFalse(verifyTitle);
	}

	@Test(priority = 5)
	public void testForNull() {
		Object verifyTitle = null;
		assertNull(verifyTitle);
	}

	@Test(priority = 6)
	public void testForNotNull() {
		Object verifyTitle = driver.getTitle();
		assertNotNull(verifyTitle);
	}

	// This is Hard Asserts
	@Test(priority = 7)
	public void testForHardAsserts() {
		driver.navigate().to("https://www.browserstack.com/");
		String actTitle = driver.getTitle();
		String verifyAssert = null;
		String expTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		boolean verifyTitlePresent = driver.getTitle()
				.equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		boolean verifyTitleChanged = driver.getTitle().equalsIgnoreCase("Testing Platform | BrowserStack");

		assertEquals(expTitle, actTitle);
		assertNotEquals(expTitle, "BrowserStack");
		assertTrue(verifyTitlePresent);
		assertFalse(verifyTitleChanged);
		assertNull(verifyTitlePresent);
		assertNotNull(verifyAssert);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
