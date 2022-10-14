package com.AgilecrmAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AgileCrm.pages.CompanyPage;
import com.AgileCrm.pages.LoginPage;

public class CompanyModuleTestCase extends BaseClass {

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("This is a before method");
		launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com");
		LoginPage loginpage = new LoginPage();
		loginpage.loginFun("cst27@yopmail.com", "Test1234");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is an after method");
		// logout from application
		driver.quit();
	}

	@Test
	public void verifyAddCompany() {
		click(By.id("companiesmenu"), "Click on Companies Menu");
		CompanyPage companyPage = new CompanyPage();
		companyPage.addCompany();
		// verify company

	}

}
