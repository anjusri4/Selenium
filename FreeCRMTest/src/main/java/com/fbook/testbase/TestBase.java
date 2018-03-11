package com.fbook.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fbook.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	//constructor
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream("D:\\SeleniumPrograms\\FreeCRMTest\\src\\main\\java\\co\\fbook\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
	//initialization method
	public static void initialization()  {
		/*prop= new Properties();
		FileInputStream ip= new FileInputStream("/SeleniumPrograms/FreeCRMTest/src/main/java/co/fbook/config/config.properties");*/
	
	String browserName=prop.getProperty("browser");
	if (browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		
	}
	/*else if(browserName.equalsIgnoreCase("FF")) {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium jars\\chromedriver_win32\\geckodriver.exe");
		driver =new ChromeDriver();
	}*/
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	}

}
