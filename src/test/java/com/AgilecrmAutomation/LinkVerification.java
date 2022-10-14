package com.AgilecrmAutomation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LinkVerification extends BaseClass {
	@Test(groups = { "regression", "sanity" })
	public void main(String browser) {
		launchBrowser("browser");
		driver.navigate().to("https://www.amazon.com");
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		for (WebElement e : elements) {
			String link = e.getAttribute("href");
			if (link != null && link.startsWith("http")) {
				URL url;
				try {
					url = new URL(link);
					URLConnection urlConnection = url.openConnection();
					HttpURLConnection connection = (HttpURLConnection) urlConnection;
					connection.connect();
					int StatusCode = connection.getResponseCode();
					if (StatusCode != 200) {
						System.out.println(StatusCode + ":url" + link);
					}
					connection.disconnect();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		}

	}

}
