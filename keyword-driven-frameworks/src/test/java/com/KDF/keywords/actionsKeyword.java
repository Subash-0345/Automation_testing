package com.KDF.keywords;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actionsKeyword {

	static WebDriver driver;
   static String baseUrl="https://phptravels.net/api/admin";
	// openBrowser()
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// goToURL()
	public static void goToURL() {
		driver.get(baseUrl);
	}

	// enterUserName()
	public static void enterUserName() {
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("admin@phptravels.com");
	}

	// enterPassWord()
	public static void enterPassWord() {
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("demoadmin");
	}

	// clickLogin()
	public static void clickLogin() {
		WebElement login = driver.findElement(By.className("btn-primary"));
		login.click();
	}

	// clickCancelBookings
	public static void clickCancelBookings() {
		WebElement clickCancel = driver
				.findElement(By.xpath("//*[@id='layoutDrawer_content']/main/div/div[2]/div[3]/a/div/div"));
		clickCancel.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	// quitBrowser
	public static void quitBrowser() {
		driver.quit();
	}

}
