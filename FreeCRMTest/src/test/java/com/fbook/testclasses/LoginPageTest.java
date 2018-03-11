package com.fbook.testclasses;
import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fbook.qa.pages.LoginPage;
import com.fbook.testbase.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	//HomePage homePage;
	public LoginPageTest() {
		super();//super class constuctor is called
	}
	@BeforeMethod
	public void setup()  {
		initialization();
		loginPage =new LoginPage();
	}
	@Test(priority=1)
	public void loginpagetitle() {
		String title=loginPage.validateLoginTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
		
	}
	@Test(priority=2)
	public void loginTest() {
		loginPage.login(prop.getProperty("firstname"), prop.getProperty("lastname"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
