package Datadriven.copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataDrivenUsingApachePOI {

	WebDriver driver;
	static List<String> usernamelist = new ArrayList<String>();
	static List<String> passwordlist = new ArrayList<String>();
    @Dataprovider(name = "login")
	public void readExcel() throws IOException {

		FileInputStream excel = new FileInputStream("/home/mitrah182/projects/selenium/one.xlsx");
		Workbook workbook = new XSSFWorkbook(excel);
		Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowiter = sheet.iterator();

		while (rowiter.hasNext()) {
		
			Row rowval = rowiter.next();

			Iterator<Cell> colIter = rowval.iterator();
			int i = 2;
			while (colIter.hasNext()) {
				if (i % 2 == 0) {
					usernamelist.add(colIter.next().getStringCellValue());
					System.out.println(usernamelist);
				} else {
					passwordlist.add(colIter.next().getStringCellValue());
					System.out.println(passwordlist);
				}
				i++;
			}
		}
	}
  
	public void exetest() {
		try {
			for (int i = 0; i < usernamelist.size(); i++) {
				bothcorrct(usernamelist.get(i), passwordlist.get(i));
			}
		} catch (Exception e) {
			System.out.println("\nEXceptions Caught");
		}

	}
	
//	public void beformeth() {
//		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
//		driver = new ChromeDriver();
//	}
//	
//	public void aftermeth() {
//		driver.quit();
//	}

	@Test(dataProvider = "login")
	public void bothcorrct(String usename, String passwrd) {
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://phptravels.net/api/admin");

		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		username.sendKeys(usename);

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwrd);

		WebElement login = driver.findElement(
				By.xpath("//*[@id='layoutAuthentication_content']/main/div/div/div/div[1]/div/form/div[4]/button"));
		login.click();

		driver.quit();
		System.out.println("1");
	}

}