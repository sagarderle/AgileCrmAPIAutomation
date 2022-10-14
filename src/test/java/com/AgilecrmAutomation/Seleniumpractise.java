package com.AgilecrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Seleniumpractise extends BaseClass {

	public static void main(String[] args) {
		launchBrowser("chrome");
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		WebElement parentframe = driver.findElement(By.xpath("")); 

	}

}
