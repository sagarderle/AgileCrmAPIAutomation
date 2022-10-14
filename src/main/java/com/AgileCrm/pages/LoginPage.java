package com.AgileCrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AgilecrmAutomation.BaseClass;

public class LoginPage extends BaseClass {

	public void loginFun(String username, String password) throws InterruptedException {
		WebElement uname = driver.findElement(By.name("email"));
		uname.clear();
		uname.sendKeys(username);
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys(password);
		WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
		signIn.click();

		loginFun("cst24@yopmail.com", "Test1234");
		/*
		 * loginFun("cst3@yopmail.com", "Test12345678"); loginFun("cst35@yopmail.com",
		 * "Test1234"); loginFun("cst1233@yopmail.com", "Test12345678"); loginFun("",
		 * "");
		 */

		/*
		 * if
		 * (driver.findElement(By.xpath("//a[@class='close']/parent::*")).isDisplayed())
		 * { System.out.println("Invalid username:" + username + "or password:" +
		 * password); } else {
		 * driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/a/span/img")).click();
		 * Thread.sleep(3000); driver.findElement(By.xpath(
		 * "//*[@id=\"fatMenuModal\"]/div[2]/div/div/div/div[3]/div/a")).click();
		 */

	}

	// Forgot-Password
	public static void ForgotPassword() {

		waitForVisibilityOfElement(driver.findElement(By.linkText("Password?")));
		driver.findElement(By.linkText("Password?")).click();
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("cst26@yopmail.com");
		waitForVisibilityOfElement(driver.findElement(By.xpath("//input[@value=\"Submit\"]")));
		driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click();
	}

	// Language Selection
	public static void SelectLanguage() {

		waitForVisibilityOfElement(driver.findElement(By.xpath("//div[@class=\"lang-identifier\"]")));
		driver.findElement(By.xpath("//div[@class=\"lang-identifier\"]")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class=\"dropdown-menu pull-right\"]/li"));
		for (WebElement e : elements) {
			String text = e.getAttribute("value");
			System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase("English")) {
				e.click();
			}
			/*
			 * } else if (e.getText().equalsIgnoreCase("Español")) { e.click(); break; }
			 * else if (e.getText().equalsIgnoreCase("Italiano")) { e.click(); break; } else
			 * if (e.getText().equalsIgnoreCase("Pусский")) { e.click(); break; } else if
			 * (e.getText().equalsIgnoreCase("Français")) { e.click(); break; } else if
			 * (e.getText().equalsIgnoreCase("Português")) { e.click(); break; } else {
			 * System.out.println("Please select appropriate language"); } }
			 */

		}

	}

}
