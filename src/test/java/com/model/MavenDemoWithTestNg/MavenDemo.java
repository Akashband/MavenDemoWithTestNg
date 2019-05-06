package com.model.MavenDemoWithTestNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MavenDemo {
	public WebDriver driver;
  
	 @Test(priority=1)
	  public void loginwithvalidds() 
	  {
		  System.out.println("Testing dsd github....");
		  String act_title1=driver.getTitle();
		  String exp_title1="Welcome: Mercury Tours";
		  Assert.assertEquals(act_title1, exp_title1);
		  System.out.println("The title of Mercury page is"+act_title1);
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
	  	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
	  	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  	  boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  	  boolean exp_flag1=true;
	  	  Assert.assertEquals(act_flag1, exp_flag1);
	  	  System.out.println("The Flight Finder image is displayed");
	  	  System.out.println("User1 is login successfully ");
	  	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  }
	  	@Test(priority=2)
	    public void verifySignonpage()
	    {
	  	  String act_title1=driver.getTitle();
	  	  String exp_title1="Sign-on: Mercury Tours";
	  	  Assert.assertEquals(act_title1, exp_title1);
	  	  System.out.println("user is on sign on page");
	    }
	 @Test(priority=3)
	  	public void loginwithinvalidds() 
	    { 
		 String act_title3=driver.getTitle();
	  	 String exp_title3="Sign-on: Mercury Tours";
	  	 Assert.assertEquals(act_title3, exp_title3);
	  	 System.out.println("Sign on screen title is:"+act_title3);
	  	 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap");
	  	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword");
	  	 driver.findElement(By.xpath("//input[@name='login']")).click();
	  	 boolean act_flag2=driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
	  	 Assert.assertTrue(act_flag2);
	  	 System.out.println("Sign on image is displayed:"+act_flag2);
	    }
	 
	  	@BeforeMethod
	    public void getAllCookies() 
	    {
	  	 Set<Cookie> cookies= driver.manage().getCookies();
	  	 for(Cookie cookie:cookies)
	  	 {
	  		 System.out.println(cookie.getName());
	  	 }
	    }

	 @AfterMethod
	 public void CaptureScreenShot() throws IOException 
	  {
	  	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  	FileUtils.copyFileToDirectory(src, new File("E:\\Users\\IRG\\workspace\\Testngproject13-04\\Screenshot1\\"));
	   }

	 @BeforeClass
	  public void maximizeBrowser()
	  {
		  driver.manage().window().maximize();
	  }

	 @AfterClass
	  public void deletAllcookies() 
	  {
		  driver.manage().deleteAllCookies();
	  }

	 @BeforeTest
	  public void enterApplicationUrl()
	  {
		  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  }

	 @AfterTest
	  public void dbconncetion() 
	  {
		System.out.println("db conncetion is closed");  
	  }
	 @BeforeSuite
	  public void openbrowser()
	  {
		  System.setProperty("webdriver.chrome.driver","E:\\Selenium\\New Chrome driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  System.out.println("Chrome browser is opened successfully");
	  }

	 @AfterSuite
	  public void closeBrowser() 
	  {
		  driver.close();
	  }
	}