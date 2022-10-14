package com.AgilecrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginpageModuleTestCase extends BaseClass {
	@Test(groups = { "regression", "sanity" })
	@Parameters({ "browser", "username", "password" })
	public void beforeClass() throws InterruptedException {
		System.out.println("This is before method");
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\chrome\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		launchBrowser("browser");
		driver.navigate().to("https://mytesttechnique.agilecrm.com");
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("sagar01@yopmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Test1234");
		WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
		signIn.click();
	}

	public void afterClass() {
		System.out.println("This is after method");
		// logout
		driver.quit();
	}

	public void verifyForgotPassword() {
		waitForVisibilityOfElement(driver.findElement(By.linkText("Password?")));
		driver.findElement(By.linkText("Password?")).click();
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("sagar01@yopmail.com");
		waitForVisibilityOfElement(driver.findElement(By.xpath("//input[@value=\"Submit\"]")));
		driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click();
	}
}
