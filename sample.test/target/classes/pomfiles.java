import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pomfiles {
	static String searchWord = "python";
	static ArrayList<String> lists = new ArrayList<String>();
	static String urls ;
	static String oriText = "Python Tutor: Learn Python, JavaScript, C, C++, and Java by ...";
	static int i=1;

	public static void sendText(WebDriver driver) {
		driver.findElement(By.name("q")).sendKeys(searchWord + Keys.ENTER);
	}

	public static void hitLinks(WebDriver driver) {
		
		first: while(i<10) {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			Iterator<WebElement> myIt = links.iterator();

			while (myIt.hasNext()) {
				urls = myIt.next().getText();
				lists.add(urls);

				if (urls.contains(oriText)) {
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
