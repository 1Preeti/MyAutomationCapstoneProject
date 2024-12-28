package com.Scenario2;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	WebDriver driver;
	LoginPage loginPage;
	AdminPage adminPage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to Orange HRM
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Initialize page objects
		loginPage = new LoginPage(driver);
		adminPage = new AdminPage(driver);
	}

	@Test(priority = 1)
	public void loginTest() {
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickLoginButton();

		// Assertion for successful login
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Failed!");
	}

	@Test(priority = 2)
	public void verifyMenuOptions() {
		int menuCount = adminPage.getMenuOptions().size();
		Assert.assertEquals(menuCount, 12, "Menu option count mismatch!");
		System.out.println("Menu Option Count: " + menuCount);

		adminPage.clickAdminMenu();
	}

	@Test(priority = 3)
	public void searchByUsername() {
		adminPage.searchByUsername("Admin");
		int records = adminPage.getRecordCount();
		System.out.println("Records found for username 'Admin': " + records);
		Assert.assertTrue(records > 0, "No records found!");
		adminPage.refreshPage();
	}

	@Test(priority = 4)
	public void searchByUserRole() {
		adminPage.searchByUserRole("Admin");
		int records = adminPage.getRecordCount();
		System.out.println("Records found for role 'Admin': " + records);
		Assert.assertTrue(records > 0, "No records found!");
		adminPage.refreshPage();
	}

	@Test(priority = 5)
	public void searchByUserStatus() {
		adminPage.searchByUserStatus("Enabled");
		int records = adminPage.getRecordCount();
		System.out.println("Records found for status 'Enabled': " + records);
		Assert.assertTrue(records > 0, "No records found!");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
