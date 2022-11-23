package stepDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefThree {

	WebDriver driver;
	static String searchWord = "python";
	static String urls = "";
	static int pages = 11;
	static ArrayList<String> lists = new ArrayList<String>();
	static int A;

	@Given("user in entering the broswer")
	public void user_in_entering_the_broswer() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "/home/mitrah182/projects/selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@When("then user is enter keyword {string}.")
	public void then_user_is_enter_keyword(String searchWord) {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.google.com/");
		WebElement sendWords = driver.findElement(By.name("q"));
		sendWords.sendKeys(searchWord + Keys.ENTER);
	}

	@And("the user is get the link {string}")
	public void the_user_is_get_the_link(String oriText) throws InterruptedException {
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
					System.out.println("The position is:" + lists.indexOf(urls));
					driver.findElement(By.partialLinkText(oriText)).click();
					driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
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

	@Then("user should reach the page title {string}")
	public void user_should_reach_the_page_title(String titleString) {
		// Write code here that turns the phrase above into concrete actions
		String link = driver.getTitle();

		if (link.equalsIgnoreCase(titleString)) {
			System.out.println("_______The User is Reached The Page_______");
			driver.quit();
		} else {
			System.out.println("_______The User is Not Reached The Page_______");
			driver.quit();
		}
	}
}
