package com.android.tests;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.android.base.CivilBase;
import com.android.pages.NewUserPage;


public class WelcomeMessage extends CivilBase{

	@BeforeTest
	public static void setUp() throws Exception{
		setup();
	}
	
	@Test
	public static void welcomePage() throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement notifyPermission=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NewUserPage.allowNotifications)));
		
		notifyPermission.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.findElement(By.xpath(NewUserPage.startWidgetBtn)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(NewUserPage.startWidgetBtn)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(NewUserPage.getStartedBtn)).click();
		
		WebElement allowNavigation= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NewUserPage.allowNavigationBtn)));
		allowNavigation.click();
		
		WebElement language = driver.findElement(By.xpath(NewUserPage.selectEnglish));
		language.click();
		
		
		WebElement mobileNoElement = driver.findElement(By.xpath(NewUserPage.mobileField));

		// Step 1: Tap to focus (required for Flutter TextField)
		Point p = mobileNoElement.getLocation();
		int x = p.getX() + 20;
		int y = p.getY() + 20;

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tapSequence = new Sequence(finger, 1);

		tapSequence.addAction(
		        finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y)
		);
		tapSequence.addAction(
		        finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())
		);
		tapSequence.addAction(
		        finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())
		);

		driver.perform(Collections.singletonList(tapSequence));

		// Step 2: Enter text using Appium mobile command
		driver.executeScript("mobile: type", Map.of("text", "1234567890"));

	}
	
	
	
	//@AfterTest
	public static void close() {
		String str=tearDown();
		System.out.println(str);
	}
}
