package stepdefinitons;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageobjects.Accountpage;
import pageobjects.Landingpage;
import pageobjects.Loginpage;
import resources.Base;

@RunWith(Cucumber.class)
public class Login extends Base {
	
	public WebDriver driver;
	Landingpage landingpage;
	Loginpage loginpage;
	Accountpage accountpage;

	
	@Given("^Open any Browser$")
	public void Open_any_Browser() throws IOException 
	{
		
		driver = initializeBrowser();
		
	}
	
	@And("^Navigate to Login page$")
	public void navigate_to_login_page() throws InterruptedException 
	{
		driver.get(prop.getProperty("url"));
		
		landingpage = new Landingpage(driver);
		landingpage.myaccountdropdown().click();
		landingpage.accountloginpage().click();
		Thread.sleep(2000);
		
		
	}
	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email,	String password)
	{
		loginpage = new Loginpage(driver);
		loginpage.emailid().sendKeys(email);
		loginpage.password().sendKeys(password);		
		
	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button()
	{
		loginpage.submitbutton().click();
	}
	
	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login()
	{
		accountpage = new Accountpage(driver);
		Assert.assertTrue(accountpage.myaccountpage().isDisplayed());
	}
	
	@After
	public void closebrowser()
	{
		driver.close();
	}


}
