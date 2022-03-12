package Page;

import java.io.IOException;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Pim 
{
	public static WebDriver driver;
	Login login;
	Email verify_email;
	String username="atridurgesh";
	String organisation_name="Think Bridge";
	String email="durgeshatri95123@gmail.com";
	String url="https://jt-dev.azurewebsites.net/#/SignUp";
	String url1="https://www.gmail.com";
	String password="Durgeshatri123";
	
	public Pim()throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\atrid\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException,IOException
	{
		login=new Login(driver);
		login.register(username, organisation_name, email);
	}
	
	@Test(priority=2)
	public void verifyEmail() throws InterruptedException, IOException
	{
		driver.get(url1);
		verify_email=new Email(driver);
		verify_email.login(email, password);
		verify_email.confirmEmail();
	}
	
}
