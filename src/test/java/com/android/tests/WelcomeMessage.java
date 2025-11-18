package com.android.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.android.base.CivilBase;
import com.android.pages.NewUserPage;

public class WelcomeMessage extends CivilBase {

	@BeforeTest
	public static void setUp() throws Exception {
		setup();
	}

	@Test
	public static void loginPage() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement notifyPermission = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(NewUserPage.allowNotifications)));
		
		if(notifyPermission.isDisplayed()) {
			welcomePage();
		}
		
		else {
			existingUser();
		}

	}

	public static void welcomePage() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement notifyPermission = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(NewUserPage.allowNotifications)));

		notifyPermission.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(NewUserPage.startWidgetBtn)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(NewUserPage.startWidgetBtn)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(NewUserPage.getStartedBtn)).click();

		WebElement allowNavigation = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(NewUserPage.allowNavigationBtn)));
		allowNavigation.click();

		WebElement language = driver.findElement(By.xpath(NewUserPage.selectEnglish));
		language.click();

		
		Thread.sleep(5000); 
		existingUser();
		 
			
	}
	
	public static void existingUser() throws Exception{
		
		  
		  //driver.findElement(By.xpath(NewUserPage.mobileFieldXpath));
				  coOrdinates(380,1484);
				  
				  WebElement mobileNoElement =driver.findElement(By.xpath(NewUserPage.mobileFieldXpath));
				  //driver.findElement(By.className(NewUserPage.mobileNumberFieldClass));
				 
		  //mobileNoElement.click(); 
		  //mobileNoElement.clear();
		  mobileNoElement.sendKeys("1234567890");
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		  driver.findElement(By.xpath(NewUserPage.sendOTP)).click();
		  
		  List<WebElement> elements = driver.findElements(By.className("android.view.View"));
		  elements.get(0).click();
		  Thread.sleep(2000);
		  elements.get(0).sendKeys("2");
		  Thread.sleep(2000);
		  elements.get(1).sendKeys("2");
		  Thread.sleep(2000);
		  elements.get(2).sendKeys("2");
		  Thread.sleep(2000);
		  elements.get(3).sendKeys("2");
		  Thread.sleep(2000);
		  elements.get(4).sendKeys("2");
		  Thread.sleep(2000);
		  elements.get(5).sendKeys("2");
		 
		
		
	}

	// @AfterTest
	public static void close() {
		String str = tearDown();
		System.out.println(str);
	}
}
