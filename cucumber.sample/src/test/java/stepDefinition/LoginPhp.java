package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPhp {
	WebDriver driver;

	@Given("user is enetering the browser.")
	public void user_is_enetering_the_browser() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://phptravels.net/api/admin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@When("User is entering Username {string} and enter the password {string} too.")
	public void user_is_entering_username_and_enter_the_password_too(String string, String string2) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("email")).sendKeys(string);
		driver.findElement(By.name("password")).sendKeys(string2);
		Thread.sleep(2000);
	}

	@And("click the login button.")
	public void click_the_login_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(2000);
	}

	@Then("click booking.")
	public void click_booking() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[text()='Bookings']")).click();

	}

	@And("The user should be reach the dashboard.")
	public void the_user_should_be_reach_the_dashboard() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String currentString = driver.getCurrentUrl();
		if (currentString.equalsIgnoreCase("https://phptravels.net/api/admin/bookings")) {
			System.out.println("____The Test case is passed____");
			driver.quit();
		} else {
			System.out.println("____The Test case is NOT passed____");
		}
	}
}
