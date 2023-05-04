package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-email")
	private WebElement emailid;	
	
	public WebElement emailid()
	{
		return emailid;
	}
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	public WebElement password()
	{
		return password;
	}
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement submitbutton;
	
	public WebElement submitbutton()
	{
		return submitbutton;
	}
	
	
	
	

}
