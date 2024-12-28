package com.TestCases;


import org.testng.annotations.BeforeTest;

import com.Pages.HomePage;
import com.Pages.IndexPage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass 
{
	
	public WebDriver driver;
	public HomePage hp;
	public IndexPage ip;
	
  @BeforeTest
  public void setUp()
  {
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	  driver.get("https://www.demoblaze.com/");
	  hp=new HomePage(driver);
	  ip=new IndexPage(driver);
  }
}
