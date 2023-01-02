package StepPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class openGoogle {
	WebDriver driver;

	@Given("user is enter a link {string}")
	public void user_is_enter_a_link(String link) {
		driver = new ChromeDriver();
		driver.get(link);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("user is entering search word {string}")
	public void user_is_entering_search_word(String search) {
		WebElement inputField = driver.findElement(By.name("q"));
		inputField.sendKeys(search);
	}

	@When("enter the search button")
	public void enter_the_search_button() {
		driver.findElement(By.name("btnK")).click();

	}

	@Then("user should reach the result page")
	public void user_should_reach_the_result_page() {
		String actString = "Cucumber - Google Search";
		String exeString = driver.getTitle();
		assertEquals(exeString, actString);
		driver.quit();
	}
}
