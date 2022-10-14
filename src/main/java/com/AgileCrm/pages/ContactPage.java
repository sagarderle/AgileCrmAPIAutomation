package com.AgileCrm.pages;

import org.openqa.selenium.By;

import com.AgilecrmAutomation.BaseClass;

public class ContactPage extends BaseClass {

	public void addNewContact() throws InterruptedException {

		waitForVisibilityOfElement(driver.findElement(By.xpath("\"//*[@id=\\\"contactsmenu\\\"]\"")));
		driver.findElement(By.xpath("//*[@id=\"contactsmenu\"]")).click();
		// Thread.sleep(8000);
		driver.findElement(By.xpath("//button[contains(text(),'Add Contact')]")).click();
		Thread.sleep(3000);

		// click(By.id("contactsmenu"), "Click on Contact Menu");
		// click(By.id("AddContact"), "Click on Add Contact Button");
		driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys("steve");
		driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys("jobs");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("cst1@yopmail.com");
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("9923557856");
		click(By.xpath("//*[@id=\"person_validate\"]"), "Click on Save Button");
	}

	// driver.findElement(By.xpath("//*[@id=\"importInModalForNewUser\"]/div[2]/div/div/div[1]/button")).click();
	// driver.findElement(By.xpath("//*[@id=\"view-list\"]/div/button/text()")).click();
}
