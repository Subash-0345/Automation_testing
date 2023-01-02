package StepPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dataTableExample1 {
	WebDriver driver;

	@Given("enter the URL {string}")
	public void enter_the_url(String URL) {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("enter username and enter password")
	public void enter_username_and_enter_password(DataTable dataTable) {
		List<List<String>> listStrings = dataTable.asLists(String.class);
		String username = listStrings.get(0).get(0);
		String password = listStrings.get(0).get(1);
		driver.findElement(By.name("name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("click the login button")
	public void click_the_login_button() {
		driver.findElement(By.id("rememberMe")).click();
		driver.findElement(By.xpath("//*[text()='Login']")).click();
	}

	@Then("Verify the page and quit")
	public void verify_the_page_and_quit() {
		String actString = driver.getTitle();
		String exeString = "";
		assertEquals(exeString, actString);
		driver.quit();
	}
}
