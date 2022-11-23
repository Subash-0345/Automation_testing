package OpertaionsUringJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Find_links {

	WebDriver driver;
	static String urls = "";
	static String oriText = "Jim Whitehurst Left IBM Because He'd Rather Be CEO";
	static String searchWord = "ibm founder";
	static int pages = 11;
	static ArrayList<String> lists = new ArrayList<String>();
	static int A;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		WebElement sendWords = driver.findElement(By.name("q"));
		sendWords.sendKeys(searchWord + Keys.ENTER);

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
					System.out.println("The position is:"+p);
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