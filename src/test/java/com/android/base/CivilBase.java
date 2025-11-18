package com.android.base;

import java.net.URI;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class CivilBase {

	public static AndroidDriver driver;
	
	public static void setup() throws Exception{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:deviceName", "emulator-5554");
		caps.setCapability("appium:appPackage", "com.civilbook.civilbookprovider");
		caps.setCapability("appium:appActivity", "com.civilbook.civilbookprovider.MainActivity");
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),caps);
		
	}
	
	public static String tearDown() {
		if(driver!=null) {
			driver.quit();
			
			return "driver closed successfully";
		}
		
		else {
			return "driver not closed yet";
		}
		
	}
	
	
	public static void coOrdinates(int x, int y) throws Exception{
		
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence tap = new Sequence(finger,1);
		
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x,y));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Collections.singletonList(tap));
	}
}
