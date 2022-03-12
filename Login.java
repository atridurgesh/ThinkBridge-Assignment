package Page;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Login 
{
WebDriver driver;
	//Pim link text web element find through id

	
	//add employee link text web element find through id 
	@FindBy(xpath="//input[@id='name']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@id='orgName']")@CacheLookup
	WebElement txt_orgname;
	
	@FindBy(xpath="//input[@id='singUpEmail']")@CacheLookup
	WebElement txt_email;
	
	@FindBy(xpath="//span[@class='black-color ng-binding']")@CacheLookup
	WebElement checkbox_terms;
	
	@FindBy(xpath="//div[@id='language']")@CacheLookup
	WebElement language;
	
	@FindBy(xpath="//button[normalize-space()='Get Started']")@CacheLookup
	WebElement btn_register;
	

	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@Test
	public void register(String username,String organisation_name,String email) throws InterruptedException
	{ 
		language.click();
		List<WebElement> so= driver.findElements(By.xpath("(//a[@class='ui-select-choices-row-inner'])"));
		int p=so.size();
		System.out.println(p);
		ArrayList<String> arr=new ArrayList<String>();
		for(int i=1;i<=p;i++)
		{
			String value=driver.findElement(By.xpath("(//a[@class='ui-select-choices-row-inner'])["+i+"]")).getText();	
			arr.add(value);
			System.out.println(value);
		}
		if(arr.contains("English")&&arr.contains("Dutch"))
		{
				System.out.println("Dropdown Contains English and Dutch Both");
		}
		else
		if(arr.contains("English"))
		{
			System.out.println("Dropdown Contains Only English");
		}
		else
		if(arr.contains("Dutch"))
		{
			System.out.println("Dropdown Contains Only Dutch");
		}
		else
		{
			System.out.println("Dropdown does not contain english nor dutch");
		}
		
		txt_username.sendKeys(username);
		txt_orgname.sendKeys(organisation_name);
		txt_email.sendKeys(email);
		
		checkbox_terms.click();
		btn_register.click();
		Thread.sleep(5000);
		
	}
}