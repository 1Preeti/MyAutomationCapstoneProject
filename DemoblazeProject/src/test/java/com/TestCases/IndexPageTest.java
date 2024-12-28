package com.TestCases;

import org.testng.annotations.*;

public class IndexPageTest extends BaseClass {
  @Test
  public void pageSetup() 
  {
	  ip=hp.doLogin("preeti28", "verma345");
  }
  
  @Test(priority=1)
  public void validateCategories()
  {
	  ip.getAllCategories();
  }
  
  @Test(priority=2)
  public void  validateOptions()
  {
	  ip.getAllOptions();
  }
  
  @Test(priority=3)
  public void validateAppUrl()
  {
	  ip.getAppUrl();
  }
   @Test(priority=4) 
   public void launchCartPage()
   {
	   ip.launchCartPage();
   }
  
}
