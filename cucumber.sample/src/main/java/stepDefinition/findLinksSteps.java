package stepDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class findLinksSteps {

	WebDriver driver;
	static String urls = "";
	static String oriText = "Top Python Courses Online - Updated [September 2022]";
	static int pages = 11;
	static ArrayList<String> lists = new ArrayList<String>();
	static int A;

	@Given("user is entering google.co.in")
	public void user_is_entering_google_co_in() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
		driver = new ChromeDriver();
        
		driver.get("https://www.google.com/");
	}

	@When("user is typing the search term {string}")
	public void user_is_typing_the_search_term(String searchString) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys(searchString);
	}

	@When("enter the return key")
	public void enter_the_return_key() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("the user should see the link is displayed.")
	public void the_user_should_see_the_link_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		first: for (int i = 0; i < pages; i++) {
			A = i + 1;
			System.out.println("Page No:" + A);
			List<WebElement> links = driver.findElements(By.tagName("a"));
			Iterator<WebElement> myIt = links.iterator();

			while (myIt.hasNext()) {
				urls = myIt.next().getText();
				lists.add(urls);

				if (urls.contains(oriText)) {
					int p = lists.indexOf(urls);
					System.out.println("The position is:" + p);
					System.out.println("{" + oriText + "} links is here..!");
					driver.findElement(By.partialLinkText(oriText)).click();
					break first;
				} else if (!lists.contains(oriText) && lists.size() == links.size()) {
					lists.clear();
					driver.findElement(By.id("pnnext")).click();
					continue first;
				}
				continue;
			}

		}
	}

}
