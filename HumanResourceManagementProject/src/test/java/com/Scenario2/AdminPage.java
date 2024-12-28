package com.Scenario2;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminPage {
	WebDriver driver;

	// Locators
	By menuOptions = By.cssSelector(".oxd-main-menu-item");
	By usernameSearchField = By.xpath("//label[text()='Username']/../following-sibling::div/input");
	By roleDropdown = By.xpath("//label[text()='User Role']/../following-sibling::div//select");
	By statusDropdown = By.xpath("//label[text()='Status']/../following-sibling::div//select");
	By searchButton = By.xpath("//button[text()='Search']");
	By recordCount = By.cssSelector(".orangehrm-background-container .oxd-table-card");
	By refreshButton = By.xpath("//button[text()='Reset']");

	// Constructor
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public List<WebElement> getMenuOptions() {
		return driver.findElements(menuOptions);
	}

	public void clickAdminMenu() {
		driver.findElement(By.linkText("Admin")).click();
	}

	public void searchByUsername(String username) {
		driver.findElement(usernameSearchField).sendKeys(username);
		driver.findElement(searchButton).click();
	}

	public void searchByUserRole(String role) {
		Select selectRole = new Select(driver.findElement(roleDropdown));
		selectRole.selectByVisibleText(role);
		driver.findElement(searchButton).click();
	}

	public void searchByUserStatus(String status) {
		Select selectStatus = new Select(driver.findElement(statusDropdown));
		selectStatus.selectByVisibleText(status);
		driver.findElement(searchButton).click();
	}

	public int getRecordCount() {
		return driver.findElements(recordCount).size();
	}

	public void refreshPage() {
		driver.findElement(refreshButton).click();
	}
}