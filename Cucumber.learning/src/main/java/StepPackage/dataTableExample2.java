package StepPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dataTableExample2 {
	WebDriver driver;
	String URL;

	@Given("the user enter the URL {string}")
	public void the_user_enter_the_url(String Url) {
		URL = Url;
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("the userenter username and enter password")
	public void the_userenter_username_and_enter_password(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String userName = data.get(0).get("Username");
		String passWord = data.get(0).get("Password");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(passWord);
	}

	@Then("user click the login button")
	public void user_click_the_login_button() {
		driver.findElement(By.id("rememberMe")).click();
		driver.findElement(By.xpath("//*[text()='Login']")).click();
	}

	@Then("verify the page and quit")
	public void verify_the_page_and_quit() {
		String actString = driver.getTitle();
		String exeString = "Augio Web";
		assertEquals(exeString, actString);
		driver.quit();
	}
}
