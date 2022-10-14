package com.AgilecrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.AgileCrm.pages.CompanyPage;
import com.AgileCrm.pages.LoginPage;

public class CompanyTest extends BaseClass {

	public static void main(String[] args) throws TimeoutException, InterruptedException {
		CompanyTest company = new CompanyTest();
		company.launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com");
		LoginPage loginpage = new LoginPage();
		loginpage.loginFun("cst27@yopmail.com", "Test1234");
		click(By.id("companiesmenu"), "Click on Company menu");
		/*
		 * waitForVisibilityOfElement(driver.findElement(By.
		 * xpath("//button[contains(text(),'Add Company')]")));
		 * click(By.xpath("//button[contains(text(),'Add Company')]"),
		 * "Click on Add Company button");
		 * waitForElementToBeClickable(By.id("company_name"), "Click on Company name");
		 * driver.findElement(By.id("company_name")).sendKeys("tester01");
		 * click(By.id("continue-company"), "Click on Continue Edit button");
		 * FluentWait(By.name("email-select")); Select select = new
		 * Select(driver.findElement(By.name("email-select"))); List<WebElement>
		 * emailDropDownList = select.getOptions(); for (WebElement element :
		 * emailDropDownList) { String text = element.getAttribute("value");
		 * System.out.println(text); } FluentWait(By.xpath("//*[@id=\"country\"]"));
		 * Select select1 = new
		 * Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
		 * List<WebElement> countryDropDownList = select1.getOptions(); for (WebElement
		 * el : countryDropDownList) { String text = el.getAttribute("value");
		 * System.out.println(el.getText()); if (el.getText().contentEquals("India")) {
		 * el.click(); }
		 * 
		 * }
		 */
		CompanyPage companypage = new CompanyPage();
		companypage.addCompany();

	}
}
