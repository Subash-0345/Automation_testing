package TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PomCase.SampleOne;

public class Sample {
	@Test
	public void loginTest(){
		
    System.setProperty("webdriver.chrome.driver","/home/mitrah182/projects/selenium/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://phptravels.net/api/admin");
    driver.manage().window().maximize();
    
    SampleOne.username(driver).sendKeys("admin@phptravels.com");
    SampleOne.password(driver).sendKeys("demoadmin");
    SampleOne.rembMe(driver).click();
    SampleOne.loginBtn(driver).click();
    SampleOne.quit(driver);
  
	}
}
