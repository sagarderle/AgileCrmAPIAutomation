package com.AgilecrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonBigIndianFestival extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		launchBrowser("chrome");
		driver.navigate().to("http://www.amazon.in");
		try {
			Actions action = new Actions(driver);
			Thread.sleep(2000);
			WebElement elementToClick = driver.findElement(
					By.xpath("//img[contains(@src,'https://m.media-amazon.com/images/I/81ptp2B5TQL._SX3000_.jpg')"));
			action.click(elementToClick).build().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		List<WebElement> pdtDetails = driver
				.findElements(By.xpath("//span[@class='a-size-mini']/following::div[@id='mobile-card-title']"));
		for (int i = 0; i <= pdtDetails.size() - 1; i++) {
			String details = pdtDetails.get(i).getText();
			System.out.println("ProductDetails:" + details);
		}

	}

}
