package com.TestCases;

import org.testng.annotations.*;
import org.testng.Assert;


public class HomePageTest extends BaseClass {
  @Test(priority=1)
  public void vaidateListOfOptions() 
  {
	  int total=hp.getTotalOptions();
	  Assert.assertEquals(total, 8);
	  System.out.println("Total Options are: "+total);
  }
  
  @Test(priority=2)
  public void validateOptions()
  {
	hp.getOptionsText();  
  }
  
  @Test(priority=3)
  public void validatesignIn()
  {
	  hp.doSignUp("preeti28", "verma345");
  }
  
  @Test(priority=4)
  public void validateLogin()
{
	 hp.doLogin("preeti28","verma345");
 }
  }
