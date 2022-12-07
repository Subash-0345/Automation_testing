package Datadriven.copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class dataDrivenuUsingJXL {

	String[][] data;
	WebDriver driver;
		
	@DataProvider(name = "logindata")
	public String[][] logindataprovider() throws BiffException, IOException{
		
		data = getExcelData();
		
		return data;
	}
	
	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream("/home/mitrah182/projects/selenium/TWO.xls");
		
		Workbook workbook = Workbook.getWorkbook(excel);
		
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int colCount = sheet.getColumns();
		
		String testdata[][]=new String[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++){
			for(int j=0;j<colCount;j++) {
				
				testdata[i-1][j] = sheet.getCell(j,i).getContents();
			}
		}
		return testdata;
	}
	
	@BeforeTest
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
		  driver = new ChromeDriver();
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@Test(dataProvider = "logindata" )
	public void loginCred(String usename, String passwrd) {
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		 driver.get("https://phptravels.net/api/admin");
		
		 WebElement username=driver.findElement(By.xpath("//input[@name='email']"));
		 username.sendKeys(usename);
		 
		 WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		 password.sendKeys(passwrd);
		 
		 WebElement login=driver.findElement(By.xpath("//*[@id='layoutAuthentication_content']/main/div/div/div/div[1]/div/form/div[4]/button"));
		 login.click();
		 
	}
}
