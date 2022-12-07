package com.Selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Downloadfile {
	@Test
	public static void dwnFile() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
   		 WebDriver driver = new ChromeDriver();
   		 driver.manage().window().maximize();
   		 driver.get("https://fastest.fish/test-files");
   		 
   		 WebElement clickfile = driver.findElement(By.xpath("//*[@id='vue']/table/tbody/tr[1]/td[1]/a"));
   		 clickfile.click();
   		 
   		 Thread.sleep(5000);
   		  File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		  
   		  try {
			FileUtils.copyFile(screenShot, new File("/home/mitrah182/Pictures/Screenshots/screen.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
   		 Thread.sleep(4000);
   		 driver.quit();
   		Thread.sleep(4000);
   		
   		 File fileLoc = new  File("//home//mitrah182//Downloads");
   		 File[] totalfile = fileLoc.listFiles();
   		 
   		 for (File file : totalfile) {
			if ( file.getName().equals("civic_renewal_forms.zip")) {
				System.out.println("The file is downloaded");
				break;
			}	
		}
   }
}
