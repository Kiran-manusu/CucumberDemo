package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
	
	public WebDriver driver;

	public Landingpage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myaccountdropdown;
	
	public WebElement myaccountdropdown()
	{
		return myaccountdropdown;
	}
	
	@FindBy(linkText = "Login")
	private WebElement accountloginpage;
	
	public WebElement accountloginpage()
	{
		return accountloginpage;
	}

}
