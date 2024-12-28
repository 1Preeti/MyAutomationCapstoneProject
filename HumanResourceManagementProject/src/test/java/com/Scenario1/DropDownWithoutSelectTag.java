package com.Scenario1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DropDownWithoutSelectTag {
  @Test
  public void testDropdown()
  {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  driver.findElement(By.xpath("//span[text()='Admin']")).click();
	  
	  //dropdown
	  driver.findElement(By.xpath("(//i[contains(@class,'xd-select-text--arrow')])[1]")).click();
	  
	  //select option admin
	  driver.findElement(By.xpath("//div[@class='oxd-select-option']//span[text()='Admin']")).click();
	   
	  
  }

}
