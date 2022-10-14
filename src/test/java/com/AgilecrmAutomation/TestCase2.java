package com.AgilecrmAutomation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase2 extends BaseClass {
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is beforeTest method");
		launchBrowser("chrome");
		driver.get("http://www.google.com");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is beforeMethod");
	}
	
  @Test
  public void test1() {
	  System.out.println("This is test1 Method");
  }
  @Test
  public void test2() {
	  System.out.println("This is test2 Method");
	  System.out.println(driver.getTitle());
	  Assert.fail("test2 failed");
  }
  @Test(dependsOnMethods="test2")
  public void test3() {
  }

  
  
  
}
