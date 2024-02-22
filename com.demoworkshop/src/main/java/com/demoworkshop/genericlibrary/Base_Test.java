package com.demoworkshop.genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Test extends FrameworkLibrary {
	public WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	public void browserSetup() throws IOException {
		if(getPropertyValue("browser").equals("chrome")){
				driver = new ChromeDriver();
		}else if(getPropertyValue("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com");
		initObjects(driver);	
	}
	@AfterMethod(alwaysRun = true)
	public void browserTearDown() {
		driver.quit();
		softAssert.assertAll();
	}
}
