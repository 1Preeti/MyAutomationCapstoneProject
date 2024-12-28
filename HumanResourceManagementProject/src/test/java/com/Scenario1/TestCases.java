package com.Scenario1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases 
{
	@Test(priority=1)
	public void register()
	{
		System.out.println("This is register test");
		AssertJUnit.assertEquals(true,true);
	}

	@Test(priority=2)
	public void login()
	{
		System.out.println("This is login test");
		AssertJUnit.assertEquals(true,false);
	}

}