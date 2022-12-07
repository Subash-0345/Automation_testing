package Datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothCrt {
	@Test
	 @Parameters({"username","password"})
	public static void bothcorrct(String usename, String passwrd) {
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://phptravels.net/api/admin");
		
		 WebElement username=driver.findElement(By.xpath("//input[@name='email']"));
		 username.sendKeys(usename);
		 
		 WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		 password.sendKeys(passwrd);
		 
		 WebElement login=driver.findElement(By.xpath("//*[@id='layoutAuthentication_content']/main/div/div/div/div[1]/div/form/div[4]/button"));
		 login.click();
		 
		 driver.quit();
	}
	
}
