package PomCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SampleOne {

	public static WebElement username(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='email']"));
	}
	public static WebElement password(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='password']"));
	}
	public static WebElement rembMe(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='layoutAuthentication_content']/main/div/div/div/div[1]/div/form/div[3]/div/label/div"));
	}
	public static WebElement loginBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='layoutAuthentication_content']/main/div/div/div/div[1]/div/form/div[4]/button"));
	}
	public static void quit(WebDriver driver) {
		 driver.quit();
	}


}
