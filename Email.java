package Page;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Email
{
WebDriver driver;
	//Pim link text web element find through id

	
	//add employee link text web element find through id 
	@FindBy(xpath="//input[@type='email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@name='password']")@CacheLookup
	WebElement txt_password;
	
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement btn_next;
	
	@FindBy(xpath="//span[@name='JabaTalks Developme.']")
	WebElement sender;
	
	@FindBy(xpath="//a[normalize-space()='Confirm your account']")
	WebElement link_confirm;
	
	public Email(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@Test
	public void login(String email,String password) throws InterruptedException
	{
		txt_email.sendKeys(email);
		btn_next.click();
		Thread.sleep(3000);
		txt_password.sendKeys(password);
		Thread.sleep(1000);
		btn_next.click();
		Thread.sleep(5000);
	}
	@Test
	public void confirmEmail() throws InterruptedException
	{ Thread.sleep(1000);
		JavascriptExecutor execute=(JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", sender);
	//	sender.click();
		Thread.sleep(3000);
		link_confirm.click();
	}
}
