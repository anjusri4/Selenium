package com.fbook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fbook.testbase.TestBase;

public class LoginPage extends TestBase{
	
//define page factory
	@FindBy(name="firstname")
	WebElement  firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	//@FindBy(xpath="//class[")
	
	//initiate page factory object by initelements 
	//initiate all webelements with driver
	//this -will load current class objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	public String validateLoginTitle() {
		return driver.getTitle();
	}
	public void login(String fn,String ls) {
		firstname.sendKeys(fn);
		lastname.sendKeys(ls);
	}
}
