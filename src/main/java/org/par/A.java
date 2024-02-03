package org.par;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;

import org.Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sam.FbloginPojo;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.it.Data;
import io.github.bonigarcia.wdm.WebDriverManager;

public class A extends BaseClass {
	
	@BeforeClass
	private void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	private void startDate() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test(retryAnalyzer = Failed.class)
	private void tc3()  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	@Test
	private void tc2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("mahathirmohamed2002@gmail.com");
		
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("Maha@7200");
			}
	@Test
	private void tc1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
	}
}
