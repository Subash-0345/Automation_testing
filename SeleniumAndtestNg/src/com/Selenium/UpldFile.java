package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UpldFile {

	@Test
	public static void upFile() {
		 System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
  		 WebDriver driver = new ChromeDriver();
  		 driver.manage().window().maximize();
  		 
  		 driver.get("file:///home/mitrah182/projects/selenium/index.html");

  		 
  		 WebElement upFile = driver.findElement(By.id("userfiles"));
  		 upFile.sendKeys("/home/mitrah182/projects/selenium/test file.doc");
  		 
  		 WebElement sendfile = driver.findElement(By.id("usersend"));
  		 sendfile.click();
  		 
	}
	
}
