package com.AgilecrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmazonElectronicSearch extends BaseClass {

	public static void main(String[] args) throws NumberFormatException {
		launchBrowser("chrome");
		driver.navigate().to("http://www.amazon.in");
		selectDropDownValByText(driver.findElement(By.id("searchDropdownBox")), "Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
		click(By.id("nav-search-submit-button"), "Click on Search button");
		List<WebElement> electronics = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		List<WebElement> price = driver
				.findElements(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-price']"));
		for (int i = 0; i <= electronics.size() - 1; i++) {
			String names = electronics.get(i).getText();
			String laptopprices = price.get(i).getText().trim();
			try {
				int number = Integer.parseInt("laptopprices");
				if (number < 30000) {
					System.out.println(names + " : " + number);
				}
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
	}

}
