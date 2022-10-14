package com.AgilecrmAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrm.pages.DealsPage;
import com.AgileCrm.pages.LoginPage;

public class DealsTestCases extends BaseClass {

	@Test(groups = { "regression", "sanity" })
	@Parameters({ "browser", "username", "password" })
	public void main(String browser, String username, String password) throws Exception {
		launchBrowser("browser");
		driver.navigate().to("https://mytesttechnique.agilecrm.com/");
		LoginPage loginPage = new LoginPage();
		loginPage.loginFun("sagar01@yopmail.com", "Test1234");
		click(By.id("dealsmenu"), "Click on Deals Menu");
		DealsPage dealspage = new DealsPage();
		dealspage.changeDealsStatus("New", "Prospect");

	}

}
