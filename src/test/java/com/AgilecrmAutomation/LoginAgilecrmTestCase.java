package com.AgilecrmAutomation;
//package com.google.common.base.Function;

import com.AgileCrm.pages.LoginPage;

public class LoginAgilecrmTestCase extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\chrome\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		// driver.navigate().to("https://realestateautomation.agilecrm.com/");
		// WebElement username = driver.findElement(By.name("email"));
		// username.sendKeys("cst5@yopmail.com");
		// WebElement password = driver.findElement(By.name("password"));
		// password.sendKeys("Test1234");
		LoginAgilecrmTestCase login1 = new LoginAgilecrmTestCase();
		login1.launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com");
		LoginPage.ForgotPassword();
		LoginPage.SelectLanguage();

	}
}
