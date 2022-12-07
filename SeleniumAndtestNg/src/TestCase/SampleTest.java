package TestCase;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PomCase.SampleTwo;

public class SampleTest {

	@Test
	public static void Login() {
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://phptravels.net/api/admin");

	
		PageFactory.initElements(driver, SampleTwo.class);
		

		SampleTwo.username.sendKeys("admin@phptravels.com");

		SampleTwo.password.sendKeys("demoadmin");

		SampleTwo.Submit.submit();


		SampleTwo.menu.click();
		
		SampleTwo.settings.click();
		
		SampleTwo.watermarks.click();
		
		SampleTwo.Enable().selectByValue("0");
		

		

//		System.out.println(6);
//		SampleTwo.selectsone.selectByIndex(0);
//		System.out.println(7);
	}
}
