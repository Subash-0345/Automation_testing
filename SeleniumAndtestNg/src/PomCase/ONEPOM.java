package PomCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ONEPOM {

	@FindBy(id = "dropdown1") 
	public static WebElement selectOnesElement;
	public static Select selectOne() {
		Select one = new Select(selectOnesElement);
		return one;
	}
	
}
