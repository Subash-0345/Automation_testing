package PomCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SampleTwo {

	@FindBy(xpath = "//input[@name='email']")
	public static WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	public static WebElement password;
	
	@FindBy(xpath  = "//*[@id='layoutAuthentication_content']/main/div/div/div/div[1]/div/form/div[3]/div/label/div")
	public static WebElement Submit;
	
	@FindBy(id = "dropdownMenuProfile")
	public static WebElement menu;
	
	@FindBy(xpath = "/html/body/nav/div/div/div/div[3]/ul/li[2]")
    public static WebElement settings;
	
	@FindBy(id = "watermark-tab")
	public static WebElement watermarks;
	
	@FindBy(xpath = "//select[@name='wm_status']") static WebElement enablest;
	public static Select Enable() {
		Select sends= new Select(enablest);
		return sends;
	}
	
}
