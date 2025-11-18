package com.android.base;

import java.net.URI;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CivilBase {

	public static AppiumDriver driver;
	
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
}
